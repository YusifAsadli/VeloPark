package com.example.velofinalproject.repositories;

import com.example.velofinalproject.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByName(String name);
}
