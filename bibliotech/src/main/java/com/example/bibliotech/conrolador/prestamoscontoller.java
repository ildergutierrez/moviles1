package com.example.bibliotech.conrolador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotech.models.prestadosmodelos;
import com.example.bibliotech.service.prestamosServer;

@RestController
@RequestMapping("/api/prestamos")
public class prestamoscontoller {
    @Autowired
    prestamosServer variableServer;

    //obtener todos los prestamos
    @GetMapping("/obtener")
    public List<prestadosmodelos> obtener() {
        return variableServer.obtener();
    }
    //buscar por id
    @GetMapping("/buscar/{id}")
    public prestadosmodelos buscarPorId(@PathVariable String id) {
        return variableServer.buscarPorId(id);
    }

    //crear prestamo
    @PostMapping("/crear")
    public prestadosmodelos insertar(@RequestBody prestadosmodelos prestamo) {
        return variableServer.insertar(prestamo);
    }

    //eliminar prestamo
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        return variableServer.eliminar(id);
    }

    
}
