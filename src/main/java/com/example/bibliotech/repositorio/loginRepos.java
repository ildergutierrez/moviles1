/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.bibliotech.repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.bibliotech.models.loginmodelos;

/**
 *
 * @author pc
 */
public interface loginRepos extends MongoRepository<loginmodelos, String> {
    public loginmodelos findByUsuario(String usuario);
    public loginmodelos findByPassword(String password);
    
}
