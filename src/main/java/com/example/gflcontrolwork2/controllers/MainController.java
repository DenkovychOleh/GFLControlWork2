package com.example.gflcontrolwork2.controllers;

import com.example.gflcontrolwork2.entities.Car;
import com.example.gflcontrolwork2.entities.Client;
import com.example.gflcontrolwork2.entities.Driver;
import com.example.gflcontrolwork2.entities.Order;
import com.example.gflcontrolwork2.repositories.CarRepository;
import com.example.gflcontrolwork2.repositories.ClientRepository;
import com.example.gflcontrolwork2.repositories.DriverRepository;
import com.example.gflcontrolwork2.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController {

    private final ClientRepository clientRepository;
    private final DriverRepository driverRepository;
    private final CarRepository carRepository;
    private final OrderRepository orderRepository;

    @GetMapping("/driver")
    public String showDriver(Model model){
        List<Driver> drivers = driverRepository.findAll();
        model.addAttribute("driver", drivers);
        return "drivers";
    }
    @GetMapping("/cars")
    public String showCars(Model model){
        List<Car> cars = carRepository.findAll();
        model.addAttribute("car", cars);
        return "cars";
    }
}
