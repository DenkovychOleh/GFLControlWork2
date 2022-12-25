package com.example.gflcontrolwork2.controllers;

import com.example.gflcontrolwork2.entities.Client;
import com.example.gflcontrolwork2.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    private final ClientRepository clientRepository;

    @GetMapping("/clients")
    public String showClients(Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients",clients);
        return "clients";
    }
}
