package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "contactos")

public class Contactos implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la contactos.

    @Id //id contactos es la llave de la tabla contactos. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_contactos") //decir cual es el nombre en la base de datos. Se hace la asociación 
    private long idContactos;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;


    public Contactos() {
    }

    public Contactos(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
