package com.example.velofinalproject.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 2000)
    private String description;
    private Double price;
    @Column(length = 2000)
    private String potoUrl;
    private Float quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
