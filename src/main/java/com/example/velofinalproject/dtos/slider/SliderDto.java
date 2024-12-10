package com.example.velofinalproject.dtos.slider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SliderDto {
    private Long id;
    private String photoUrl;
    private String title;
    private String description;
}
