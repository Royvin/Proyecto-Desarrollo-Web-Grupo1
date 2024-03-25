package com.proyecto.dao;

import com.proyecto.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    List<Usuario> findByEmail(String email);
}