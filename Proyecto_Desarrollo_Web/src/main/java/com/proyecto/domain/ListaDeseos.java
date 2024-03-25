package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "ListaDeseos")
public class ListaDeseos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ListaDeseos")
    private Long idProducto;

    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias; //pensar si lo vamos a poner
    private String rutaImagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_ListaDeseos")
    Producto producto;

    public ListaDeseos() {
    }

    public ListaDeseos(String descripcion, String detalle, double precio, int existencias, String imagen, boolean activo) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias; //pensar si lo vamos a dejar
        this.rutaImagen = imagen;
        this.activo = activo;
    }
    
    public Long getIdProducto() { 
        return idProducto;
 
    }
    public Long getIdListaDeseos() {
        Long idListaDeseos = null;
    return idListaDeseos;
}

}

