package com.example.velofinalproject.services.impls;

import com.example.velofinalproject.dtos.category.CategoryCreateDto;
import com.example.velofinalproject.dtos.category.CategoryDto;
import com.example.velofinalproject.dtos.category.CategoryUpdateDto;
import com.example.velofinalproject.models.Category;
import com.example.velofinalproject.repositories.CategoryRepository;
import com.example.velofinalproject.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpls implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpls(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createCategory(CategoryCreateDto categoryCreateDto) {
        Category category = new Category();
        category.setName(categoryCreateDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryUpdateDto categoryUpdateDto, Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setName(categoryUpdateDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryUpdateDto findUpdateCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        CategoryUpdateDto categoryUpdateDto = modelMapper.map(category, CategoryUpdateDto.class);
        return categoryUpdateDto;
    }

    @Override
    public List<CategoryDto> getHomeCategories() {
        List<CategoryDto> categories = categoryRepository.findAll().stream().map(category -> modelMapper.map(category, CategoryDto.class)).toList();
        return categories;
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }


}
