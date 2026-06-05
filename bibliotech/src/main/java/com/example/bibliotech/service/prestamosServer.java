package com.example.bibliotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bibliotech.models.prestadosmodelos;
import com.example.bibliotech.repositorio.prestamosRepo;

@Service
public class prestamosServer {
    @Autowired
    prestamosRepo variableRepo;
    public prestadosmodelos insertar(prestadosmodelos prestamo) {
        return variableRepo.save(prestamo);
    }
    //eliminar prestamo
    public String eliminar(String id) {
        variableRepo.deleteById(id);
        return "Prestamo eliminado correctamente";
    }

    //obtener todos los prestamos
    public List<prestadosmodelos> obtener() {
        return variableRepo.findAll();
    }    

    //buscar por id
    public prestadosmodelos buscarPorId(String id) {
        return variableRepo.findById(id).orElse(null);
    }
}
