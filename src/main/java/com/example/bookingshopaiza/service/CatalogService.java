package com.example.bookingshopaiza.service;

import com.example.bookingshopaiza.entity.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> findAll();
    Catalog save(Catalog category);
    Catalog findById(Long id);
}