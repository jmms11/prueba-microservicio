package com.pichincha.microservicio.controller.impl;

import com.pichincha.microservicio.controller.IMovimientoController;
import com.pichincha.microservicio.service.IMovimientoService;
import com.pichincha.microservicio.service.dto.MovimientoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
@Slf4j
public class MovimientoControllerImpl implements IMovimientoController {

    @Autowired
    IMovimientoService movimientoService;

    @Override
    @GetMapping("/reportes")
    public ResponseEntity<List<MovimientoDTO>> getListMovimientos(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
                                                                  @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta,
                                                                  @RequestParam String identificacionCliente) throws Exception {
        log.info("Inicio: getListMovimientos");
        return ResponseEntity.ok(movimientoService.getReportes(fechaDesde,fechaHasta,identificacionCliente));
    }

    @Override
    @GetMapping("/{idMovimiento}")
    public ResponseEntity<Object> getMovimientoById(@PathVariable Long idMovimiento) throws Exception {
        log.info("Inicio: getMovimientoById");
        return ResponseEntity.ok(movimientoService.getMovimientoById(idMovimiento));
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> createMovimiento(@RequestBody MovimientoDTO movimiento) throws Exception {
        log.info("Inicio: createMovimiento");
        MovimientoDTO movimientoDTO = movimientoService.crearMovimiento(movimiento);
        log.info("Fin: createMovimiento");
        return new ResponseEntity<Object>(movimientoDTO, HttpStatus.OK);
    }

    @Override
    @PatchMapping("/{idMovimiento}")
    public ResponseEntity<Object> updateMovimiento(@PathVariable Long idMovimiento,
                                                   @RequestBody MovimientoDTO movimiento) throws Exception {
        log.info("Inicio: updateMovimiento");
        movimientoService.actualizarMovimiento(idMovimiento,movimiento);
        log.info("Fin: updateMovimiento");
        return new ResponseEntity<Object>(movimiento, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{idMovimiento}")
    public ResponseEntity<Object> deleteMovimientoById(@PathVariable Long idMovimiento) {
        log.info("Inicio: deleteMovimientoById");
        movimientoService.eliminarMovimiento(idMovimiento);
        return ResponseEntity.ok("Movimiento eliminado correctamente");
    }
}
