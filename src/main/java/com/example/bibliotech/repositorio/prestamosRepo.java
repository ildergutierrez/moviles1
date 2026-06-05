/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bibliotech.repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.bibliotech.models.prestadosmodelos;


public interface prestamosRepo extends MongoRepository<prestadosmodelos, String> {


}
