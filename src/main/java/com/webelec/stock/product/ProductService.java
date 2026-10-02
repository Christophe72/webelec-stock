package com.webelec.stock.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
    }

    @Transactional
    public Product create(ProductRequest request) {
        Product product = new Product();
        product.setReference(request.reference());
        product.setName(request.name());
        product.setQuantity(request.quantity());
        product.setPrice(request.price());
        return repository.save(product);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
