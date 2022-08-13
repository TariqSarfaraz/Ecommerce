package com.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String productName;
    private double productPrice;
    private String productDescription;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private Order order;
}
