package com.example.velofinalproject.repositories;

import com.example.velofinalproject.models.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
}
