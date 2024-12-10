package com.example.velofinalproject.dtos.testimonial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialHomeDto {
    private String description;
    private String image;
    private String userName;
}
