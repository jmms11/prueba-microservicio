package com.pichincha.microservicio.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoDTO {
    private Long movimientoId;
    private Date fecha;
    private String tipoMovimiento;
    private BigDecimal valor;
    private BigDecimal saldo;
    private Long idCuenta;
    private String numeroCuenta;
    private Long idCliente;
    private String nombreCliente;
}
