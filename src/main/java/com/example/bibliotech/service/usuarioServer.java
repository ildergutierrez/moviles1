package com.example.bibliotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.bibliotech.models.usuariosmodelos;
import com.example.bibliotech.repositorio.usuarioRepos;


@Service
public class usuarioServer {

    @Autowired
    usuarioRepos variableRepo;

    public List<usuariosmodelos> obtenerUsuarios(){
        return variableRepo.findAll();
    }

    public usuariosmodelos buscarPorTelefono(@PathVariable String telefono) {
        return variableRepo.findByTelefono(telefono);
    }
    public usuariosmodelos buscarPorId(@PathVariable String id) {
        return variableRepo.findById(id).orElse(null);
    }

    public usuariosmodelos buscarPorCorreo(@PathVariable String correo) {
        return variableRepo.findByCorreo(correo);
    }

    // Insertar
    public usuariosmodelos insertar(usuariosmodelos usuario) {
        return variableRepo.save(usuario);
    }

    // Modificar
    public usuariosmodelos modificar(String id, usuariosmodelos usuario) {
        usuario.setId(id);
        return variableRepo.save(usuario);
    }

    public String eliminar(String id) {
        variableRepo.deleteById(id);
        return "Usuario eliminado correctamente";
    }
}