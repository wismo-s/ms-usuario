package com.jei.applicacion.service;

import com.jei.dominio.entidad.Departamento;
import com.jei.web.dto.UsuarioRequestDto;
import com.jei.web.dto.UsuarioResponseDto;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDto crear(UsuarioRequestDto usuarioRequestDto);

    UsuarioResponseDto buscarPorId(Long id);
    List<UsuarioResponseDto> buscarPorDepartamento(Departamento departamento);
}
