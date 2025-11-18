package com.example.livros.dto;

import jakarta.validation.constraints.*;

public class BookRequest {
    @NotBlank @Size(max = 200)
    private String titulo;

    @NotBlank @Size(max = 120)
    private String autor;

    @Positive @Max(2100)
    private Integer anoPublicacao;

    @NotBlank @Size(max = 20)
    private String isbn;

    public BookRequest() {}

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public Integer getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}
