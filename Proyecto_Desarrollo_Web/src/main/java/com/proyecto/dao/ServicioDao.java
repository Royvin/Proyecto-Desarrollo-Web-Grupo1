package com.proyecto.dao;

import com.proyecto.domain.Servicio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioDao extends JpaRepository<Servicio, Long> {

    public List<Servicio> findByPrecioBetweenOrderByDescripcion(double precioInf, double preciosup);

}
