package com.example.velofinalproject.services;


import com.example.velofinalproject.dtos.category.CategoryCreateDto;
import com.example.velofinalproject.dtos.category.CategoryDto;
import com.example.velofinalproject.dtos.category.CategoryUpdateDto;
import com.example.velofinalproject.dtos.news.NewsCreateDto;
import com.example.velofinalproject.dtos.news.NewsDto;
import com.example.velofinalproject.dtos.news.NewsHomeDto;
import com.example.velofinalproject.dtos.news.NewsUpdateDto;
import com.example.velofinalproject.models.Category;
import com.example.velofinalproject.models.News;

import java.util.List;

public interface NewsService {
    List<NewsHomeDto> getNews();

    void createNews(NewsCreateDto newsCreateDto);
    void updateNews(NewsUpdateDto newsUpdateDto, Long id);
    void deleteNews(Long id);
    NewsUpdateDto findUpdateNews(Long id);
    List<NewsDto> getHomeNews();
    News findNewsById(Long id);
}
