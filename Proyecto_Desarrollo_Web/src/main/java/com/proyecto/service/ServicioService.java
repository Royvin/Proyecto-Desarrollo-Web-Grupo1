package com.proyecto.service;

import com.proyecto.domain.Servicio;

import java.util.List;

public interface ServicioService {

    List<Servicio> getServicios(boolean activos);

    Servicio getServicio(Servicio servicio);

    void save(Servicio servicio);

    void delete(Servicio servicio);

    List<Servicio> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
