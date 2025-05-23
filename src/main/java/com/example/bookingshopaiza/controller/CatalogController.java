package com.example.bookingshopaiza.controller;

import com.example.bookingshopaiza.entity.Catalog;
import com.example.bookingshopaiza.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public List<Catalog> getAll() {
        return catalogService.findAll();
    }

    @PostMapping
    public Catalog create(@RequestBody Catalog category) {
        return catalogService.save(category);
    }
}