package com.jei.dominio.repository;

import com.jei.dominio.entidad.Departamento;
import com.jei.dominio.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByDepartamento(Departamento departamento);
}
