package com.pichincha.microservicio.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO extends PersonaDTO {

    private Long clienteId;
    private String contrasena;
    private Boolean estado;
}
