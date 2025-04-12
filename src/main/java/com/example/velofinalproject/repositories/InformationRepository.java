package com.example.velofinalproject.repositories;

import com.example.velofinalproject.models.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
