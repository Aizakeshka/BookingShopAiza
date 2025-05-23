package com.example.bookingshopaiza.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookFilterDto {
    private String title;
    private Long genreId;
    private Long authorId;
    private Long catalogId;
    private Integer yearFrom;
    private Integer yearTo;
    public String getTitle() {
        return title;
    }

    public Long getGenreId() {
        return genreId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    // Сеттеры
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }
}