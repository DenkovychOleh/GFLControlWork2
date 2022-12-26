package com.example.gflcontrolwork2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "driver")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "experience")
    private Integer exp;
    @Column(name = "phone", nullable = false, length = 10)
    private String phone;
    @Column(name = "tariff")
    private Double tariff;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "driver_car",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Car car;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "driver_id")
    private Set<Order> orders = new LinkedHashSet<>();

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public String toString(){
        return firstName+" "+lastName;
    }
}
