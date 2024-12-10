package com.example.velofinalproject.dtos.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactAdminDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String massage;
}
