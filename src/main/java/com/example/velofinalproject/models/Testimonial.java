package com.example.velofinalproject.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="testimonials")
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String image;
    private String userName;
    private Boolean visible;

}
