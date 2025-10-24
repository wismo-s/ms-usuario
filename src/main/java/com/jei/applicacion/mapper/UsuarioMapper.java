package com.jei.applicacion.mapper;

import com.jei.dominio.entidad.Usuario;
import com.jei.web.dto.UsuarioRequestDto;
import com.jei.web.dto.UsuarioResponseDto;

public interface UsuarioMapper {
    Usuario toDomain(UsuarioRequestDto usuarioRequestDto);
    UsuarioResponseDto toDto(Usuario usuario);
}
