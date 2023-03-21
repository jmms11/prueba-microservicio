package com.pichincha.microservicio.controller.impl;

import com.pichincha.microservicio.controller.ICuentaController;
import com.pichincha.microservicio.entity.Cliente;
import com.pichincha.microservicio.service.ICuentaService;
import com.pichincha.microservicio.service.dto.CuentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cuentas")
@Slf4j
public class CuentaControllerImpl implements ICuentaController {

    @Autowired
    ICuentaService cuentaService;

    @Override
    @GetMapping
    public ResponseEntity<List<CuentaDTO>> getListCuentas() throws Exception {
        log.info("Inicio: getListCuentas");
        return ResponseEntity.ok(cuentaService.getCuentas());
    }

    @Override
    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<Object> getCuentaByNumeroCuenta(@PathVariable String numeroCuenta) throws Exception {
        log.info("Inicio: getCuentaByNumeroCuenta");
        return ResponseEntity.ok(cuentaService.getCuentaByNumeroCuenta(numeroCuenta));
    }

    @Override
    @PostMapping
    public ResponseEntity<String> createCuenta(@RequestBody CuentaDTO cuenta) {
        log.info("Inicio: createCuenta", cuenta);
        CuentaDTO cuentaCreada = cuentaService.crearCuenta(cuenta);
        log.info("Fin: createCuenta", cuentaCreada);
        return new ResponseEntity<String>("Cuenta creada correctamente con el id: "+ cuentaCreada.getCuentaId(), HttpStatus.CREATED);
    }


    @Override
    @PatchMapping("/{idCuenta}")
    public ResponseEntity<String> updateCuenta(@PathVariable Long idCuenta,@RequestBody CuentaDTO cuenta) {
        log.info("Inicio: updateCuenta", cuenta);
        cuentaService.actualizarCuenta(idCuenta,cuenta);
        log.info("Fin: updateCuenta", cuenta);
        return new ResponseEntity<String>("Cuenta actualizada correctamente con el id: "+ idCuenta, HttpStatus.CREATED);

    }

    @Override
    @DeleteMapping("/{idCuenta}")
    public ResponseEntity<String> deleteCuentaById(@PathVariable Long idCuenta) {
        log.info("Inicio: deleteCuentaById", idCuenta);
        cuentaService.eliminarCuenta(idCuenta);
        return new ResponseEntity<String> ("Cuenta eliminada correctamente",HttpStatus.OK);
    }
}
