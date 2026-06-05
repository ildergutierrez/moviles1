package com.example.bibliotech.repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.bibliotech.models.librosmodelos;

@Repository
public interface librosRepo extends MongoRepository<librosmodelos, String> {
    librosmodelos findByIsbn(Long isbn);
    librosmodelos findByTitulo(String titulo);
}
