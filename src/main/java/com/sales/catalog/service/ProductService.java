package com.sales.catalog.service;

import com.sales.catalog.dto.ProductDTO;
import com.sales.catalog.entity.Product;
import com.sales.catalog.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public List<Product> searchByName(String name) {
        String term = (name == null) ? "" : name.trim();
        if (term.isEmpty()) {
            throw new IllegalArgumentException("O parâmetro 'name' é obrigatório");
        }
        return repository.findByNameContainingIgnoreCase(term);
    }

    public Product create(ProductDTO dto) {
        String name = (dto.getName() == null) ? "" : dto.getName().trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("O campo 'name' é obrigatório");
        }

        BigDecimal price = normalizePrice(dto.getPrice());
        if (price != null && price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo");
        }

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);

        return repository.save(p);
    }

    // Atualiza name sempre; price só se vier no DTO (null = não mexe)
    public Optional<Product> update(Long id, ProductDTO dto) {
        String name = (dto.getName() == null) ? "" : dto.getName().trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("O campo 'name' é obrigatório");
        }

        BigDecimal price = normalizePrice(dto.getPrice());
        if (price != null && price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo");
        }

        return repository.findById(id).map(p -> {
            p.setName(name);

            if (dto.getPrice() != null) {
                p.setPrice(price);
            }

            return repository.save(p);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    private BigDecimal normalizePrice(BigDecimal price) {
        return price;
    }
}