package com.sales.catalog.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sales.catalog.dto.ProductDTO;
import com.sales.catalog.entity.Product;
import com.sales.catalog.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Product> list() {
        return service.findAll();
    }

    @GetMapping("/search")
    public Iterable<Product> search(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        Product saved = service.create(dto);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        return service.update(id, dto)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado");
        }
        service.delete(id);
        return ResponseEntity.ok(Map.of("message", "Produto removido"));
    }
}