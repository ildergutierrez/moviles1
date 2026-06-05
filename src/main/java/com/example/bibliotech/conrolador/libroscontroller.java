package com.example.bibliotech.conrolador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotech.models.librosmodelos;
import com.example.bibliotech.service.librosServer;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/api/libros")
@RestController
public class libroscontroller {
      @Autowired
    librosServer variableServer;
    @GetMapping("/obtenerlibros")
    public ArrayList<librosmodelos> ObtenerLibros(){
        return variableServer.ObtenerLibros();
    }
    
// public librosmodelos buscarPorId(@PathVariable String id) {
//     return variableServer.buscarPorId(id);
// } 
@GetMapping("/buscar/{isbn}")
public librosmodelos buscarPorIsbn(@PathVariable Long isbn) {
    return variableServer.buscarPorIsbn(isbn);
}
@GetMapping("/buscart/{titulo}")
public librosmodelos buscarPortitulo(@PathVariable String titulo) {
    return variableServer.buscarPortitulo(titulo);
}

@PostMapping("/insertar/")
public librosmodelos insertar(@RequestBody librosmodelos libro) {
    return variableServer.insertar(libro);
}

@PutMapping("/modificar/{id}")
public librosmodelos modificar(@PathVariable String id, @RequestBody librosmodelos libro) {
    return variableServer.modificar(id, libro);
}

@DeleteMapping("/eliminar/{id}")
public String eliminar(@PathVariable String id) {
    return variableServer.eliminar(id);
}

}
