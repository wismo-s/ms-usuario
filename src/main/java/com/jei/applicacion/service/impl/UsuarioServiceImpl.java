package com.jei.applicacion.service.impl;

import com.jei.applicacion.mapper.UsuarioMapper;
import com.jei.applicacion.service.UsuarioService;
import com.jei.dominio.entidad.Departamento;
import com.jei.dominio.entidad.Usuario;
import com.jei.dominio.repository.UsuarioRepository;
import com.jei.web.dto.UsuarioRequestDto;
import com.jei.web.dto.UsuarioResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl  implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioResponseDto crear(UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = usuarioMapper.toDomain(usuarioRequestDto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuarioGuardado);
    }

    @Override
    public UsuarioResponseDto buscarPorCorreo(String correo) {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("No se encontro usuario con correo: " + correo));

        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioResponseDto buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public List<UsuarioResponseDto> buscarPorDepartamento(Departamento departamento) {
        List<Usuario> usuarios = usuarioRepository.findByDepartamento(departamento);
        return usuarios.stream()
                .map(usuarioMapper::toDto)
                .toList();
    }

}
