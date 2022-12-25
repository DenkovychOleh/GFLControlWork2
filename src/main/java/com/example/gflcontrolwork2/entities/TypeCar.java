package com.example.gflcontrolwork2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "type_car")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TypeCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "passengers_seats")
    private Integer seats;
    @Column(name = "type", length = 30)
    String type;
    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "type_car_id")
    private Set<Car> cars = new LinkedHashSet<>();

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
