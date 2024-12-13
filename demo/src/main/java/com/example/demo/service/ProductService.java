package com.example.demo.service;

import com.example.demo.ProductRepository;
import com.example.demo.error.ProductNotFoundException;
import com.example.demo.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        List<Product> result = productRepository.getAll();

        if (result.isEmpty())
            throw new ProductNotFoundException();
        return result;
    }

    public Product get(Long id) {
        return productRepository.get(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
