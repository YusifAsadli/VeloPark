package com.example.velofinalproject.services;

import com.example.velofinalproject.dtos.product.*;
import com.example.velofinalproject.models.Product;
import com.example.velofinalproject.payload.PaginationPayload;

import java.util.List;

public interface ProductService {
    List<ProductHomeDto> getHomeProducts();

    PaginationPayload<ProductShopDto> getShopProducts(Integer currentPage);

    void createProduct(ProductCreateDto productCreateDto);
    void updateProduct(ProductUpdateDto productUpdateDto, Long id);
    void deleteProduct(Long id);
    ProductUpdateDto findUpdateProduct(Long id);
    List<ProductDto> findAllProducts();
    Product findProductById(Long id);
}
