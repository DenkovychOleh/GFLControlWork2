package com.example.gflcontrolwork2.repositories;

import com.example.gflcontrolwork2.entities.Client;
import com.example.gflcontrolwork2.entities.Driver;
import com.example.gflcontrolwork2.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}