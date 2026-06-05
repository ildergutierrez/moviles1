package com.example.bibliotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bibliotech.models.loginmodelos;
import com.example.bibliotech.repositorio.loginRepos;

@Service

public class loginServer {

    @Autowired
    loginRepos variableRepo;

    public boolean autenticar(loginmodelos login) {
        loginmodelos usuario = variableRepo.findByUsuario(login.getUsuario());
        if (usuario != null && usuario.getPassword().equals(login.getPassword())) {
            return true;
        }
        return false;
    }

    //crear usuaro la contraseña va incriptada
    public loginmodelos insertar(loginmodelos login) {
        return variableRepo.save(login);
    }

    //modificar contraseña
    //el usuario no es id, es un campo unico
    public loginmodelos modificar(String usuario, loginmodelos login) {
        loginmodelos usuarioExistente = variableRepo.findByUsuario(usuario);
        if (usuarioExistente != null) {
            usuarioExistente.setPassword(login.getPassword());
            return variableRepo.save(usuarioExistente);
        }
        return null;
    }

    //Elimiar usuario
    public void eliminar(String usuario) {
        loginmodelos usuarioExistente = variableRepo.findByUsuario(usuario);
        if (usuarioExistente != null) {
            variableRepo.delete(usuarioExistente);
        }
    }
}
