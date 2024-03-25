package com.proyecto.dao;

import com.proyecto.domain.Contactos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ContactosDao extends JpaRepository<Contactos, Long> {
    List<Contactos> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
}

