package com.example.gflcontrolwork2.repositories;

import com.example.gflcontrolwork2.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}