package com.proyecto.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "contrasenna")
    private String contrasenna;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email, String contrasenna) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenna = contrasenna;
    }
}