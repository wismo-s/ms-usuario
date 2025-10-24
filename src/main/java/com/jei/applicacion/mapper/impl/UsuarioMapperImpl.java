package com.jei.applicacion.mapper.impl;

import com.jei.applicacion.mapper.UsuarioMapper;
import com.jei.dominio.entidad.Role;
import com.jei.dominio.entidad.Usuario;
import com.jei.web.dto.UsuarioRequestDto;
import com.jei.web.dto.UsuarioResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapperImpl implements UsuarioMapper {
    @Override
    public Usuario toDomain(UsuarioRequestDto usuarioRequestDto) {
        return Usuario.builder()
                .nombre(usuarioRequestDto.getNombre())
                .apellido(usuarioRequestDto.getApellido())
                .correo(usuarioRequestDto.getCorreo())
                .role(Role.TRABAJADOR)
                .departamento(usuarioRequestDto.getDepartamento())
                .contrasena(usuarioRequestDto.getContrasena())
                .build();
    }

    @Override
    public UsuarioResponseDto toDto(Usuario usuario) {
        return UsuarioResponseDto.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .correo(usuario.getCorreo())
                .role(usuario.getRole())
                .departamento(usuario.getDepartamento())
                .build();
    }
}
