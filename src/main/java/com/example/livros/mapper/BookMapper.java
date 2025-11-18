package com.example.livros.mapper;

import com.example.livros.domain.Book;
import com.example.livros.dto.BookRequest;
import com.example.livros.dto.BookResponse;

public final class BookMapper {
    private BookMapper(){}

    public static Book toEntity(BookRequest req) {
        return new Book(null, req.getTitulo(), req.getAutor(), req.getAnoPublicacao(), req.getIsbn());
    }

    public static void copyToEntity(BookRequest req, Book entity) {
        entity.setTitulo(req.getTitulo());
        entity.setAutor(req.getAutor());
        entity.setAnoPublicacao(req.getAnoPublicacao());
        entity.setIsbn(req.getIsbn());
    }

    public static BookResponse toResponse(Book entity) {
        return new BookResponse(entity.getId(), entity.getTitulo(), entity.getAutor(),
                entity.getAnoPublicacao(), entity.getIsbn());
    }
}
