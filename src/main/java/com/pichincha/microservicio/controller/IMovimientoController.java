package com.pichincha.microservicio.controller;

import com.pichincha.microservicio.service.dto.MovimientoDTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface IMovimientoController {
    /**
     * @return ResponseEntity<List<MovimientoDTO>>
     */
    ResponseEntity<List<MovimientoDTO>> getListMovimientos(Date fechaDesde, Date fechaHasta, String identificacionCliente) throws Exception;

    /**
     * @param idMovimiento
     * @return ResponseEntity<Object>
     */
    ResponseEntity<Object> getMovimientoById(Long idMovimiento) throws Exception;

    /**
     * @param movimiento
     * @return ResponseEntity<Object>
     */
    ResponseEntity<Object> createMovimiento(MovimientoDTO movimiento) throws Exception;

    /**
     * @param idMovimiento,cuenta
     * @return ResponseEntity<String>
     */
    ResponseEntity<Object> updateMovimiento(Long idMovimiento, MovimientoDTO movimiento) throws Exception;

    /**
     * @param idMovimiento
     * @return ResponseEntity<Object>
     */
    ResponseEntity<Object> deleteMovimientoById(Long idMovimiento);
}
