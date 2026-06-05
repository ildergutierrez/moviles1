package com.example.bibliotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bibliotech.models.librosmodelos;
import com.example.bibliotech.repositorio.librosRepo;

@Service
public class librosServer {

    @Autowired
    librosRepo variableRepo;

    // Obtener todos
    public ArrayList<librosmodelos> ObtenerLibros() {
        return (ArrayList<librosmodelos>) variableRepo.findAll();
    }

    public librosmodelos buscarPorIsbn(@PathVariable Long isbn) {
        return variableRepo.findByIsbn(isbn);
    }

    public librosmodelos buscarPortitulo(@PathVariable String titulo) {
        return variableRepo.findByTitulo(titulo);
    }

    // Insertar
    public librosmodelos insertar(librosmodelos libro) {
        return variableRepo.save(libro);
    }

    // Modificar
    public librosmodelos modificar(String id, librosmodelos libro) {
        libro.setId(id);
        return variableRepo.save(libro);
    }

    public String eliminar(String id) {
        variableRepo.deleteById(id);
        return "Libro eliminado correctamente";
    }
}