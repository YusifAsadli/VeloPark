package com.example.velofinalproject.dtos.information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationDto {
    private Long id;
    private String location;
    private String number;
    private String mail;
}
