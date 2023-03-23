package com.pichincha.microservicio.controller;

import com.pichincha.microservicio.service.dto.CuentaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICuentaController {


    /**
     * @return ResponseEntity<List<CuentaDTO>>
     */
    ResponseEntity<List<CuentaDTO>> getListCuentas() throws Exception;

    /**
     * @param numeroCuenta
     * @return ResponseEntity<Object>
     */
    ResponseEntity<Object> getCuentaByNumeroCuenta(String numeroCuenta) throws Exception;

    /**
     * @param cuenta
     * @return ResponseEntity<Object>
     */
    ResponseEntity<String> createCuenta(CuentaDTO cuenta);

    /**
     * @param cuenta
     * @return ResponseEntity<String>
     */
    ResponseEntity<String> updateCuenta(Long idCuenta,CuentaDTO cuenta);

    /**
     * @param idCuenta
     * @return ResponseEntity<Object>
     */
    ResponseEntity<String> deleteCuentaById(Long idCuenta);
}
