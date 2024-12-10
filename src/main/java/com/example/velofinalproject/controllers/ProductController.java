package com.example.velofinalproject.controllers;

import com.example.velofinalproject.dtos.category.CategoryDto;
import com.example.velofinalproject.dtos.product.ProductCreateDto;
import com.example.velofinalproject.dtos.product.ProductDto;
import com.example.velofinalproject.dtos.product.ProductUpdateDto;
import com.example.velofinalproject.services.CategoryService;
import com.example.velofinalproject.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }







    @GetMapping("/admin/product")
    public String adminProduct(Model model) {
        List<ProductDto> product = productService.findAllProducts();
        model.addAttribute("products", product);
        return "/dashboard/product/index";
    }

    @GetMapping("/admin/product/create")
    public String createProduct(Model model) {
        List<CategoryDto> categories = categoryService.getHomeCategories();
        model.addAttribute("categories", categories);
        return "/dashboard/product/create";
    }

    @PostMapping("/admin/product/create")
    public String createProduct(@ModelAttribute("product") ProductCreateDto productCreateDto) {
        productService.createProduct(productCreateDto);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return "/dashboard/product/delete";
    }

    @PostMapping("/admin/product/delete/{id}")
    public String removeProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable Long id, Model model) {
        ProductUpdateDto productUpdateDto = productService.findUpdateProduct(id);
        List<CategoryDto> categories = categoryService.getHomeCategories();
        model.addAttribute("product", productUpdateDto);
        model.addAttribute("categories", categories);
        return "/dashboard/product/update";
    }

    @PostMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable Long id, ProductUpdateDto productUpdateDto) {
        productService.updateProduct(productUpdateDto, id);
        return "redirect:/admin/product";
    }

}
