package com.example.velofinalproject.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "informations")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String number;
    private String mail;
}
