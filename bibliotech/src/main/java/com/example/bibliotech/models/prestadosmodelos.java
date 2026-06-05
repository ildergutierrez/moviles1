package com.example.bibliotech.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prestamos")
public class prestadosmodelos {
    @Id
    private String id;
    private String usuario;
    private long libro_isbn;
    private String fechaPrestamo;

    public prestadosmodelos(String id, String usuario, long libro_isbn, String fechaPrestamo) {
        this.id = id;
        this.usuario = usuario;
        this.libro_isbn = libro_isbn;
        this.fechaPrestamo = fechaPrestamo;
    }

    public prestadosmodelos() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public long getLibro_isbn() {
        return libro_isbn;
    }

    public void setLibro_isbn(long libro_isbn) {
        this.libro_isbn = libro_isbn;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }


}
