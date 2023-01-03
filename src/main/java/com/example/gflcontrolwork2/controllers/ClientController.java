package com.example.gflcontrolwork2.controllers;

import com.example.gflcontrolwork2.entities.Client;
import com.example.gflcontrolwork2.entities.Order;
import com.example.gflcontrolwork2.repositories.ClientRepository;
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
public class ClientController {
    ClientRepository clientRepository;
    OrderRepository orderRepository;
    @GetMapping("/clients")
    public String showClients(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "client/clients";
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
            return "client/client_edit";
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

    @GetMapping("/clients/orders/{id}")
    public String showClientOrder(@PathVariable(name = "id") int id, Model model){
        List<Order> client = orderRepository.findByF(id);
        model.addAttribute("client",client);
        return "client/clients_orders";
    }

    @GetMapping("/clients/add")
    public String showAddClient(Model model) {
        return "add_client";
    }

    @PostMapping("/clients/new")
    public String addClient(@RequestParam String first_name, @RequestParam String last_name, @RequestParam String phone, Model model){
        Client client = new Client();
        try {
            client.setFirstName(first_name);
            client.setLastName(last_name);
            client.setPhone(phone);
            if (client.getFirstName() != null && !client.getFirstName().isBlank() && client.getLastName() != null && !client.getLastName().isBlank() && client.getPhone() != null && !client.getPhone().isBlank()) {
                model.addAttribute("client",client);
                clientRepository.save(client);
            }
            return "redirect:/clients";
        } catch (Exception ignored){
            return "redirect:/add_client";
        }
    }
}
