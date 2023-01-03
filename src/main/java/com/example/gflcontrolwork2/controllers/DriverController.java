package com.example.gflcontrolwork2.controllers;

import com.example.gflcontrolwork2.entities.Driver;
import com.example.gflcontrolwork2.repositories.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class DriverController {
    DriverRepository driverRepository;

    @GetMapping({"/drivers", "/drivers/back"})
    public String showDrivers(Model model) {
        List<Driver> drivers = driverRepository.findAll();
        model.addAttribute("drivers", drivers);
        return "driver/drivers";
    }

    @GetMapping("/drivers/delete/{id}")
    public String deleteDriver(@PathVariable(name = "id") int id) {
        Optional<Driver> driver = driverRepository.findById(id);
        driver.ifPresent(driverRepository::delete);  // clientRepository.deleteById(id);
        return "redirect:/drivers";
    }

    @GetMapping("/drivers/edit/{id}")
    public String showEditDriver(@PathVariable int id, Model model) {
        Optional<Driver> driver = driverRepository.findById(id);
        if (driver.isPresent()) {
            model.addAttribute("driver", driver.get());
            return "driver/edit";
        } else {
            return "redirect:/drivers";
        }
    }

    @PostMapping("/driver/drivers/update/{id}")
    public String updateDriver(@PathVariable int id, Driver driver) {
        try {
            if (checkDriver(driver)) {
                driverRepository.save(driver);
            }
        } catch (Exception ignored) {
        }
        return "redirect:/drivers";
    }

    @GetMapping("/drivers/add")
    public String showAddDriver(Model model) {
        return "/driver/add";
    }

    @PostMapping("/drivers/new")
    public String addDriver(@RequestParam String first_name, @RequestParam String last_name, @RequestParam Integer age, @RequestParam Integer exp, @RequestParam String phone, @RequestParam Double tariff, Model model) {
        Driver driver = new Driver();
        try {
            driver.setFirstName(first_name);
            driver.setLastName(last_name);
            driver.setAge(age);
            driver.setExp(exp);
            driver.setTariff(tariff);
            driver.setPhone(phone);
            if (checkDriver(driver)) {
                model.addAttribute("driver", driver);
                driverRepository.save(driver);
            }
            return "redirect:/drivers";
        } catch (Exception ignored) {}
        return "redirect:/add";
    }

    private boolean checkDriver(Driver driver) {
        return driver.getFirstName() != null && !driver.getFirstName().isBlank() && driver.getLastName() != null && !driver.getLastName().isBlank() && driver.getPhone() != null && !driver.getPhone().isBlank() && !driver.getTariff().isNaN() && driver.getTariff() > 0 && driver.getAge() != null && driver.getAge() >= 18 && driver.getExp() > 0;
    }
}
