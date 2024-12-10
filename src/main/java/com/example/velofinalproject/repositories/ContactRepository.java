package com.example.velofinalproject.repositories;

import com.example.velofinalproject.models.ContactUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactUser, Long>  {
}
