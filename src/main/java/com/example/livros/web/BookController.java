package com.example.livros.web;

import com.example.livros.dto.BookRequest;
import com.example.livros.dto.BookResponse;
import com.example.livros.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Tag(name = "Livros", description = "Operações CRUD para livros")
@RestController
@RequestMapping("/api/v1/livros")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @Operation(summary = "Listar livros com paginação/ordenação")
    @GetMapping
    public Page<BookResponse> list(Pageable pageable) {
        return service.list(pageable);
    }

    @Operation(summary = "Obter um livro por ID")
    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Operation(summary = "Criar um novo livro")
    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest request) {
        BookResponse saved = service.create(request);
        return ResponseEntity.created(URI.create("/api/v1/livros/" + saved.getId())).body(saved);
    }

    @Operation(summary = "Atualizar um livro existente")
    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id, @Valid @RequestBody BookRequest request) {
        return service.update(id, request);
    }

    @Operation(summary = "Excluir um livro")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
