package com.example.gflcontrolwork2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "date", nullable = false)
    private GregorianCalendar date;
    @Column(name = "start_address", nullable = false, length = 50)
    private String start;
    @Column(name = "finish_address", nullable = false, length = 50)
    private String finish;
    @Column(name = "distance", nullable = false)
    private Double dist;
    @Column(name = "passengers", nullable = false)
    private Integer passengers;
    @Column(name = "average consumption")
    private Double consumption;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
