package com.example.velofinalproject.services;

import com.example.velofinalproject.dtos.category.CategoryCreateDto;
import com.example.velofinalproject.dtos.category.CategoryDto;
import com.example.velofinalproject.dtos.category.CategoryUpdateDto;
import com.example.velofinalproject.models.Category;

import java.util.List;

public interface CategoryService {
    void createCategory(CategoryCreateDto categoryCreateDto);
    void updateCategory(CategoryUpdateDto categoryUpdateDto,Long id);
    void deleteCategory(Long id);
    CategoryUpdateDto findUpdateCategory(Long id);
    List<CategoryDto> getHomeCategories();
    Category findCategoryById(Long id);

}
