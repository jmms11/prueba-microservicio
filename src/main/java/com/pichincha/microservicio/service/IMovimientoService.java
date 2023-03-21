package com.pichincha.microservicio.service;


import com.pichincha.microservicio.service.dto.MovimientoDTO;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface IMovimientoService {

    List<MovimientoDTO> getReportes(Date fechaDesde, Date fechaHasta, String identificacionCliente) throws Exception;

    MovimientoDTO getMovimientoById(Long idMovimiento) throws Exception;

    MovimientoDTO crearMovimiento(MovimientoDTO movimiento) throws Exception;

    void actualizarMovimiento(Long idMovimiento, MovimientoDTO movimiento) throws Exception;

    void eliminarMovimiento(Long movimientoId);
}
