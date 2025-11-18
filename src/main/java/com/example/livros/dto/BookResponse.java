package com.example.livros.dto;

public class BookResponse {
    private Long id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String isbn;

    public BookResponse() {}

    public BookResponse(Long id, String titulo, String autor, Integer anoPublicacao, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public Integer getAnoPublicacao() { return anoPublicacao; }
    public String getIsbn() { return isbn; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAnoPublicacao(Integer anoPublicacao) { this.anoPublicacao = anoPublicacao; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}
