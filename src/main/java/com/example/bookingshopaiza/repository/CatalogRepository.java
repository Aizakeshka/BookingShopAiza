package com.example.bookingshopaiza.repository;

import com.example.bookingshopaiza.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}