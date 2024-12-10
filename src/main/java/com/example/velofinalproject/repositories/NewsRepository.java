package com.example.velofinalproject.repositories;

import com.example.velofinalproject.models.News;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
