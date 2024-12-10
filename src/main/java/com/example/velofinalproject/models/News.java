package com.example.velofinalproject.models;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String photoUrl;
    private Boolean visible;
    private LocalDate date;
    private String username;

//    @ManyToOne
//    private UserEntity user;
}
