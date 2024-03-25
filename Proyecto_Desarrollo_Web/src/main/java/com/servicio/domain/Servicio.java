package com.servicio.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "servicio")

public class servicio implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    @ManyToOne
    @JoinColumn(name = "servicee")
    servicio service;
    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la producto.

    @Id //id productoes la llave de la tabla producto. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_servicio") //decir cual es el nombre en la base de datos. Se hace la asociación 
    private long idServicio;
    //private long idServicio;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

    public servicio() {
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}
