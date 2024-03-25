package com.proyecto.dao;

import com.tienda.domain.Productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosDao extends JpaRepository<Productos, Long> {

    public List<Productos> findByPrecioBetweenOrderByDescripcion(double precioInf, double preciosup);

}
