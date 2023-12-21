package com.integration.challenge.service;

import java.util.List;

import com.integration.challenge.model.Product;

public interface ProductService {
public List<Product> getAll();
public Product getProductById(int productId);
public Product addOrUpdateProduct(Product product);
public String deleteProduct(int id) throws Exception;
}