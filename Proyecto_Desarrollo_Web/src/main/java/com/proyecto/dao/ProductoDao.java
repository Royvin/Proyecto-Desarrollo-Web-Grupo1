package com.proyecto.dao;

import com.proyecto.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long> {

    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double preciosup);

}
