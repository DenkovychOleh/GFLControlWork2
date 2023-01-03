package com.example.gflcontrolwork2.repositories;

import com.example.gflcontrolwork2.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("select o from Car o where o.driver.id = ?1")
    List<Car> findCar(int id);
}