package com.pichincha.microservicio.service;

import com.pichincha.microservicio.entity.Cuenta;
import com.pichincha.microservicio.service.dto.CuentaDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICuentaService {

    List<CuentaDTO> getCuentas() throws Exception;

    CuentaDTO crearCuenta(CuentaDTO cuenta);

    void actualizarCuenta(Long idCuenta, CuentaDTO cuenta);

    void eliminarCuenta(Long idCuenta);

    CuentaDTO getCuentaByNumeroCuenta(String numeroCuenta) throws Exception;

    CuentaDTO getCuentaByIdCuenta(Long cuentaId) throws Exception;
}
