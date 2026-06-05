package com.example.bibliotech.repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.bibliotech.models.usuariosmodelos;

@Repository
public interface usuarioRepos extends MongoRepository<usuariosmodelos, String> {
    usuariosmodelos findByTelefono(String telefono);
    usuariosmodelos findByCorreo(String correo);
    
}
