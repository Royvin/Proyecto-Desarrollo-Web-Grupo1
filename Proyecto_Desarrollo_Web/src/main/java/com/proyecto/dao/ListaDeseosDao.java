package com.proyecto.dao;

import com.proyecto.domain.ListaDeseos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ListaDeseosDao extends JpaRepository<ListaDeseos, Long> {
    List<ListaDeseos> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}
