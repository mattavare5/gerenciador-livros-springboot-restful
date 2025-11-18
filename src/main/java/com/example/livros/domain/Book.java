package com.example.livros.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "livros",
        uniqueConstraints = @UniqueConstraint(name = "uk_livros_isbn", columnNames = "isbn"))
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 200)
    @Column(nullable = false, length = 200)
    private String titulo;

    @NotBlank @Size(max = 120)
    @Column(nullable = false, length = 120)
    private String autor;

    @Positive @Max(2100)
    private Integer anoPublicacao;

    @NotBlank @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String isbn;

    public Book() {}

    public Book(Long id, String titulo, String autor, Integer anoPublicacao, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}
