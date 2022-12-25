package com.example.gflcontrolwork2.repositories;

import com.example.gflcontrolwork2.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}