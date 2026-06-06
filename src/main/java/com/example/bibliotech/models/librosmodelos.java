package com.example.bibliotech.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "libros")
public class librosmodelos {
    @Id
    private String id;
    private String titulo;
    private String autor;
    private String categoria;
    private Long isbn;
    private String editorial;
    private int anio_publicacion;
    private int cantidad_total;
    private int cantidad_disponible;
    private String ubicacion;

    public librosmodelos() {
    }

    public librosmodelos(String titulo, String autor, String categoria, Long isbn, String editorial,
            int anio_publicacion, int cantidad_total, int cantidad_disponible, String ubicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.isbn = isbn;
        this.editorial = editorial;
        this.anio_publicacion = anio_publicacion;
        this.cantidad_total = cantidad_total;
        this.cantidad_disponible = cantidad_disponible;
        this.ubicacion = ubicacion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public void setCantidad_total(int cantidad_total) {
        this.cantidad_total = cantidad_total;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getTitulo() {
        return titulo;
    }
public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
}
    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public int getCantidad_total() {
        return cantidad_total;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public String getUbicacion() {
        return ubicacion;
    }
      public String getId() {
        return id;
    }
}
