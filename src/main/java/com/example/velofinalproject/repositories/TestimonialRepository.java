package com.example.velofinalproject.repositories;

import com.example.velofinalproject.models.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {
}
