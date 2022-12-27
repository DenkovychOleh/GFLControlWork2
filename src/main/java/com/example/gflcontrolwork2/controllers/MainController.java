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

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController {

    private final ClientRepository clientRepository;
    private final DriverRepository driverRepository;
    private final CarRepository carRepository;
    private final OrderRepository orderRepository;

    @GetMapping("/clients")
    public String showClients(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

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

    @GetMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") int id){
        Optional<Client> client = clientRepository.findById(id);
        client.ifPresent(clientRepository::delete);  // clientRepository.deleteById(id);
        return "redirect:/clients";
    }
    @GetMapping("/clients/edit/{id}")
    public String showEditClient(@PathVariable int id, Model model){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()){
            model.addAttribute("client",client.get());
            return "client_edit";
        } else {
            return "redirect:/clients";
        }
    }

    @PostMapping("/clients/update/{id}")
    public String updateClient(@PathVariable int id, Client client) {
        try {
            if (client.getFirstName() != null && !client.getFirstName().isBlank() && client.getLastName() != null && !client.getLastName().isBlank() && client.getPhone() != null && !client.getPhone().isBlank()) {
                clientRepository.save(client);
            }
        } catch (Exception ignored) {}
        return "redirect:/clients";
    }

//    @GetMapping("/clients/orders/{id}")
//    public String showClientOrder(@PathVariable(name = "id") int id, Model model){
//        Optional<Client> client = clientRepository.findById(id);
//        if(client.isPresent()){
//            model.addAttribute("client",client);
//            return "clients_orders";
//        }
//        else {
//            return "redirect:/clients";
//        }
//    }
    @GetMapping("/clients/orders/{id}")
    public String showClientOrder(@PathVariable(name = "id") int id, Model model){
        List<Order> client = orderRepository.findByF(id);
        model.addAttribute("client",client);
        return "clients_orders";

    }
}
