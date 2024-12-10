package com.example.velofinalproject.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="contact_users")
public class ContactUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String massage;
}
