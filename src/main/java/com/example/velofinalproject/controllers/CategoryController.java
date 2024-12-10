package com.example.velofinalproject.controllers;

import com.example.velofinalproject.dtos.category.CategoryCreateDto;
import com.example.velofinalproject.dtos.category.CategoryDto;
import com.example.velofinalproject.dtos.category.CategoryUpdateDto;
import com.example.velofinalproject.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/category")
    public String category(Model model) {
        List<CategoryDto> data = categoryService.getHomeCategories();
        model.addAttribute("categories", data);
        return "/dashboard/category/index";
    }

    @GetMapping("/admin/category/create")
    public String categoryCreate() {
        return "/dashboard/category/create";
    }

    @PostMapping("/admin/category/create")
    public String categoryCreateSubmit(CategoryCreateDto categoryCreateDto) {
        categoryService.createCategory(categoryCreateDto);
        return "redirect:/admin/category";
    }
    @GetMapping("/admin/category/update/{id}")
    public String categoryUpgrade(@PathVariable Long id, Model model) {
        CategoryUpdateDto categroy=categoryService.findUpdateCategory(id);
        model.addAttribute("category", categroy);
        return "/dashboard/category/update";
    }
    @PostMapping("/admin/category/update/{id}")
    public String categoryUpgradeSubmit(@PathVariable Long id, CategoryUpdateDto categoryUpdateDto) {
        categoryService.updateCategory(categoryUpdateDto, id);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/delete/{id}")
    public String categoryDelete(@PathVariable Long id) {
        return "/dashboard/category/delete";
    }

    @PostMapping("/admin/category/delete/{id}")
    public String categoryDeleteSubmit(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/category";
    }


}
