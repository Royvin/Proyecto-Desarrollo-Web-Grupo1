package com.proyecto.dao;

import com.proyecto.domain.Contactos;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface ContactosDao extends JpaRepository <Contactos,Long> {
}
