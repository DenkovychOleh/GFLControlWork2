package com.example.gflcontrolwork2.repositories;

import com.example.gflcontrolwork2.entities.Client;
import com.example.gflcontrolwork2.entities.Driver;
import com.example.gflcontrolwork2.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.client.id = ?1")
    public List<Order> findByF(int id);
    @Query("select o from Order o where o.driver.id = ?1")
    public List<Order> findByD(int id);


}