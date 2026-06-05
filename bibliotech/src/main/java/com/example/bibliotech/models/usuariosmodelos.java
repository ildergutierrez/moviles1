package com.example.bibliotech.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import org.springframework.data.annotation.Id;

@Document(collection = "usuarios") // este es el nombre de la colección, no recuerdo que el profe alla dicho eso...
                                   // jajaja
public class usuariosmodelos {
    @Id
    private String id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String tipo_usuario;
    private Date fecha_registro;

    public usuariosmodelos() {
    }

    public usuariosmodelos(String nombre, String correo, String telefono, String direccion, String tipo_usuario,
            Date fecha_registro) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo_usuario = tipo_usuario;
        this.fecha_registro = fecha_registro;
    }

    // bien cremos los Setter de ls vribles que vamos a usar para modificar y buscar
    // datos
    public void setId(String id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // ok se crean todos los getter

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }
}