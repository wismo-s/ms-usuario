package com.jei.web.controller;

import com.jei.applicacion.service.UsuarioService;
import com.jei.dominio.entidad.Departamento;
import com.jei.web.dto.UsuarioRequestDto;
import com.jei.web.dto.UsuarioResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> crear(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto usuarioCreado = usuarioService.crear(usuarioRequestDto);
        return ResponseEntity.ok(usuarioCreado);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable Long id) {
        UsuarioResponseDto usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }
    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuarioResponseDto> buscarPorCorreo(@PathVariable String correo) {
        UsuarioResponseDto usuario = usuarioService.buscarPorCorreo(correo);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listarUsuarios(
            @RequestParam(value = "departamento", required = false) Departamento departamento) {

        List<UsuarioResponseDto> usuarios;
        usuarios = usuarioService.buscarPorDepartamento(departamento);

        return ResponseEntity.ok(usuarios);
    }
}
