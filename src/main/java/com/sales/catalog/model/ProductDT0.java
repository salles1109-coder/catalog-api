package com.sales.catalog.model;

public class ProductDT0 {
    private Long id;
    private String name;

    public ProductDT0() {}

    public ProductDT0(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}