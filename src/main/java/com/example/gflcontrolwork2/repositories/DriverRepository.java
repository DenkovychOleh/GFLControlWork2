package com.example.gflcontrolwork2.repositories;

import com.example.gflcontrolwork2.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query("select d from Driver d where d.firstName = ?1")
    public List<Driver> findByFirstName(String firstName);
}