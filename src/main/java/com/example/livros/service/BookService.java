package com.example.livros.service;

import com.example.livros.domain.Book;
import com.example.livros.dto.BookRequest;
import com.example.livros.dto.BookResponse;
import com.example.livros.exception.DuplicateResourceException;
import com.example.livros.exception.ResourceNotFoundException;
import com.example.livros.mapper.BookMapper;
import com.example.livros.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public Page<BookResponse> list(Pageable pageable) {
        return repo.findAll(pageable).map(BookMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public BookResponse getById(Long id) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado: id=" + id));
        return BookMapper.toResponse(book);
    }

    @Transactional
    public BookResponse create(BookRequest req) {
        if (repo.existsByIsbn(req.getIsbn())) {
            throw new DuplicateResourceException("ISBN já cadastrado: " + req.getIsbn());
        }
        Book entity = BookMapper.toEntity(req);
        Book saved = repo.save(entity);
        return BookMapper.toResponse(saved);
    }

    @Transactional
    public BookResponse update(Long id, BookRequest req) {
        Book existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado: id=" + id));

        if (repo.existsByIsbnAndIdNot(req.getIsbn(), id)) {
            throw new DuplicateResourceException("ISBN já cadastrado: " + req.getIsbn());
        }

        BookMapper.copyToEntity(req, existing);
        Book saved = repo.save(existing);
        return BookMapper.toResponse(saved);
    }

    @Transactional
    public void delete(Long id) {
        Book existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado: id=" + id));
        repo.delete(existing);
    }
}
