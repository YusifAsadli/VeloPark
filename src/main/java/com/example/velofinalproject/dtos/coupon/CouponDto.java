package com.example.velofinalproject.dtos.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto {
    private String name;
    private Float discount;
}
