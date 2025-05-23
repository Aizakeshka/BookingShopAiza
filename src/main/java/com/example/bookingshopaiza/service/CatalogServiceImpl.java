package com.example.bookingshopaiza.service;

import com.example.bookingshopaiza.entity.Catalog;
import com.example.bookingshopaiza.repository.CatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog save(Catalog category) {
        return catalogRepository.save(category);
    }

    @Override
    public Catalog findById(Long id) {
        return catalogRepository.findById(id).orElse(null);
    }
}