package com.example.gflcontrolwork2.repositories;
import com.example.gflcontrolwork2.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
}