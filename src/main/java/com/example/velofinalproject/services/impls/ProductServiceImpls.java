package com.example.velofinalproject.services.impls;

import com.example.velofinalproject.dtos.product.*;
import com.example.velofinalproject.models.Category;
import com.example.velofinalproject.models.Product;
import com.example.velofinalproject.payload.PaginationPayload;
import com.example.velofinalproject.repositories.ProductRepository;
import com.example.velofinalproject.services.CategoryService;
import com.example.velofinalproject.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpls implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpls(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public List<ProductHomeDto> getHomeProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductHomeDto> result = products.stream().limit(3).map(x -> modelMapper.map(x, ProductHomeDto.class)).collect(Collectors.toList());
        return result;
    }


    @Override
    public PaginationPayload<ProductShopDto> getShopProducts(Integer currentPage) {
        currentPage = currentPage == null ? 1 : currentPage > 0 ? currentPage : 1;
        Pageable pageable = PageRequest.of(currentPage - 1, 3, Sort.by("id").descending());
        Page<Product> sortProducts = productRepository.findAll(pageable);
        PaginationPayload result = new PaginationPayload<>(sortProducts.getTotalPages(), sortProducts.getContent());
        return result;
    }

    @Override
    public void createProduct(ProductCreateDto productCreateDto) {
        Product product = new Product();
        Category findCategory = categoryService.findCategoryById(productCreateDto.getCategoryId());
        product.setCategory(findCategory);
        product.setName(productCreateDto.getName());
        product.setPrice(productCreateDto.getPrice());
        product.setDescription(productCreateDto.getDescription());
        product.setPotoUrl(productCreateDto.getPotoUrl());
        product.setQuantity(productCreateDto.getQuantity());
        productRepository.save(product);

    }

    @Override
    public void updateProduct(ProductUpdateDto productUpdateDto, Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        Category findCategory = categoryService.findCategoryById(productUpdateDto.getCategoryId());
        product.setCategory(findCategory);
        product.setName(productUpdateDto.getName());
        product.setPrice(productUpdateDto.getPrice());
        product.setDescription(productUpdateDto.getDescription());
        product.setPotoUrl(productUpdateDto.getPotoUrl());
        product.setQuantity(productUpdateDto.getQuantity());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }

    @Override
    public ProductUpdateDto findUpdateProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductUpdateDto result = modelMapper.map(product, ProductUpdateDto.class);
        return result;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        List<ProductDto> products = productRepository.findAll().stream().map(x -> modelMapper.map(x, ProductDto.class)).collect(Collectors.toList());
        return products;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
