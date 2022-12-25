package com.example.gflcontrolwork2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "fuel")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "fuel", length = 30)
    private String fuel;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "fuel_id")
    private Set<Car> cars = new LinkedHashSet<>();

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
