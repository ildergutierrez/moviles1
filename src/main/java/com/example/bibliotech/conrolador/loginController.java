/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bibliotech.conrolador;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.bibliotech.service.loginServer;
import com.example.bibliotech.models.loginmodelos;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @author pc
 */

@RestController
@RequestMapping("/api/login")
public class loginController {
    @Autowired
    loginServer variableServer;

    @PostMapping("/autenticar")
    public boolean autenticar(@RequestBody loginmodelos login) {
        return variableServer.autenticar(login);
    }
    //crear usuario
    @PostMapping("/crear")
    public loginmodelos insertar(@RequestBody loginmodelos login) {
        return variableServer.insertar(login);
    }

    //modificar contraseña
    @PutMapping("/modificar/{usuario}")
    public loginmodelos modificar(@PathVariable String usuario, @RequestBody loginmodelos login) {
        return variableServer.modificar(usuario, login);
    }

    //Elimiar usuario
    @DeleteMapping("/eliminar/{usuario}")
    public void eliminar(@PathVariable String usuario) {
        variableServer.eliminar(usuario);
    }

}
