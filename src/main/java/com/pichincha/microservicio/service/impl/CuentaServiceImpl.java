package com.pichincha.microservicio.service.impl;


import com.pichincha.microservicio.entity.Cliente;
import com.pichincha.microservicio.entity.Cuenta;
import com.pichincha.microservicio.repository.ICuentaRepo;
import com.pichincha.microservicio.service.ICuentaService;
import com.pichincha.microservicio.service.dto.ClienteDTO;
import com.pichincha.microservicio.service.dto.CuentaDTO;
import com.pichincha.microservicio.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaServiceImpl implements ICuentaService {

    @Autowired
    private ICuentaRepo cuentaRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<CuentaDTO> getCuentas() throws Exception{
        List<CuentaDTO> cuentaDTOS = new ArrayList<>();
        List<Cuenta> cuentas = cuentaRepository.findAll();
        if (cuentas == null){
            throw new Exception("No existen cuentas");
        }
        for (Cuenta cuenta: cuentas) {
            cuentaDTOS.add(mapper.mapCuentaToCuentaDTO(cuenta));
        }
        return cuentaDTOS;
    }

    @Override
    public CuentaDTO getCuentaByNumeroCuenta(String numeroCuenta) throws Exception {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta).orElse(null);
        if (cuenta == null){
                throw new Exception("La cuenta no existe");
        }
        return mapper.mapCuentaToCuentaDTO(cuenta);
    }

    @Override
    public CuentaDTO getCuentaByIdCuenta(Long cuentaId) throws Exception{
        Cuenta cuenta = cuentaRepository.findByCuentaId(cuentaId).orElse(null);
        if (cuenta == null){
            throw new Exception("La cuenta no existe");
        }
        return mapper.mapCuentaToCuentaDTO(cuenta);
    }

    @Override
    public CuentaDTO crearCuenta(CuentaDTO cuenta) {
        Cuenta cuentaCreada = cuentaRepository.save(mapper.mapCuentaDTOToCuenta(cuenta));
        cuenta.setCuentaId(cuentaCreada.getCuentaId());
        return cuenta;
    }

    @Override
    public void actualizarCuenta(Long idCuenta, CuentaDTO cuenta) {
        cuenta.setCuentaId(idCuenta);
        cuentaRepository.save(mapper.mapCuentaDTOToCuenta(cuenta));
    }

    @Override
    public void eliminarCuenta(Long idCuenta) {
        cuentaRepository.deleteById(idCuenta);
    }

}
