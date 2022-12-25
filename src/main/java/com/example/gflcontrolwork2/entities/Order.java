package com.example.gflcontrolwork2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "order")
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

}
