package com.example.bibliotech.conrolador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.bibliotech.models.usuariosmodelos;
import com.example.bibliotech.service.usuarioServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping("/api/usuarios")
@RestController
public class usuarioscontroller {

    @Autowired
    usuarioServer variableServer;

    @GetMapping("/obtenerusuarios")
    public List<usuariosmodelos> ObtenerUsuarios() {
        return variableServer.obtenerUsuarios();
    }

    @GetMapping("/buscarusuario/{id}")
    public usuariosmodelos BuscarUsuario(@PathVariable String id) {
        return variableServer.buscarPorId(id);
    }
    @GetMapping("/buscartelefono/{telefono}")
    public usuariosmodelos BuscarUsuarioTelefono(@PathVariable String telefono) {
        return variableServer.buscarPorTelefono(telefono);
    }
    @GetMapping("/buscarcorreo/{correo}")
    public usuariosmodelos BuscarUsuarioCorreo(@PathVariable String correo) {
        return variableServer.buscarPorCorreo(correo);
    }
  
@PostMapping("/crear")
public usuariosmodelos insertarUsuario(@RequestBody usuariosmodelos usuario) {
    return variableServer.insertar(usuario);
}

@PutMapping("/modificar/{id}")
public usuariosmodelos putMethodName(@PathVariable String id, @RequestBody usuariosmodelos usuario) {  
    return variableServer.modificar(id, usuario);
}
    @DeleteMapping("/eliminar/{id}")
    public String EliminarUsuario(@PathVariable String id) {
        return variableServer.eliminar(id);
    }

}