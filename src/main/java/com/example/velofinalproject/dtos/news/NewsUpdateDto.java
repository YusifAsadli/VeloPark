package com.example.velofinalproject.dtos.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsUpdateDto {
    private Long id;
    private String title;
    private String description;
    private String photoUrl;
    private Boolean visible;
    private LocalDate date;
    private String username;
}
