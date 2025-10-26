package com.jei.web.dto;

import com.jei.dominio.entidad.Departamento;
import com.jei.dominio.entidad.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private Role role;
    private Departamento departamento;
}
