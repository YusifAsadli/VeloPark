package com.example.velofinalproject.dtos.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsHomeDto {
    private String title;
    private String description;
    private String photoUrl;
    private LocalDate date;
    private String username;
}
