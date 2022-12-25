package com.example.gflcontrolwork2.repositories;

import com.example.gflcontrolwork2.entities.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {
}