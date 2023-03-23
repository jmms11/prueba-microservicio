package com.pichincha.microservicio.service.impl;


import com.pichincha.microservicio.entity.Cuenta;
import com.pichincha.microservicio.entity.Movimiento;
import com.pichincha.microservicio.repository.IClienteRepo;
import com.pichincha.microservicio.repository.ICuentaRepo;
import com.pichincha.microservicio.repository.IMovimientoRepo;
import com.pichincha.microservicio.service.IMovimientoService;
import com.pichincha.microservicio.service.dto.MovimientoDTO;
import com.pichincha.microservicio.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovimientoServiceImpl implements IMovimientoService {

    @Autowired
    private IMovimientoRepo movimientoRepository;

    @Autowired
    private IClienteRepo clienteRepository;

    @Autowired
    private ICuentaRepo cuentaRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public MovimientoDTO getMovimientoById(Long idMovimiento) throws Exception{
        Movimiento movimiento = movimientoRepository.findByMovimientoId(idMovimiento).orElse(null);
        if (movimiento == null){
            throw new Exception("Movimiento no existe");
        }
        return mapper.mapMovimientoToMovimientoDTO(movimiento);
    }

    @Override
    public MovimientoDTO crearMovimiento(MovimientoDTO movimiento) throws Exception {
        Cuenta cuenta = cuentaRepository.findByCuentaId(movimiento.getIdCuenta()).orElse(null);
        if ("retiro".equalsIgnoreCase(movimiento.getTipoMovimiento())) {
            if (cuenta == null){
                throw new Exception("La cuenta no existe");
            }
            if (cuenta.getSaldoInicial().compareTo(movimiento.getValor()) < 0) {
                throw new Exception(
                        "El valor de retiro es mayor al saldo disponible: " + movimiento.getValor());
            }
            BigDecimal saldoActual = cuenta.getSaldoInicial().subtract(movimiento.getValor().abs());
            movimiento.setSaldo(saldoActual);
            cuenta.setSaldoInicial(saldoActual);
        }else if ("deposito".equalsIgnoreCase(movimiento.getTipoMovimiento())){
            BigDecimal saldoActual = cuenta.getSaldoInicial().add(movimiento.getValor().abs());
            movimiento.setSaldo(saldoActual);
            cuenta.setSaldoInicial(saldoActual);
        }
        cuentaRepository.save(cuenta);
        Movimiento movimientoCreado = movimientoRepository.save(mapper.mapMovimientoDTOToMovimiento(movimiento));
        movimiento.setMovimientoId(movimientoCreado.getMovimientoId());

        return movimiento;
    }

    @Override
    public void actualizarMovimiento(Long idMovimiento, MovimientoDTO movimiento) throws Exception{
        Cuenta cuenta = cuentaRepository.findByCuentaId(movimiento.getIdCuenta()).orElse(null);
        if ("Retiro".equalsIgnoreCase(movimiento.getTipoMovimiento())) {
            if (cuenta == null){
                throw new Exception("La cuenta no existe");
            }
            if (cuenta.getSaldoInicial().compareTo(movimiento.getValor()) < 0) {
                throw new Exception(
                        "El valor de retiro es mayor al saldo disponible: " + movimiento.getValor());
            }
            BigDecimal saldoActual = cuenta.getSaldoInicial().subtract(movimiento.getValor().abs());
            movimiento.setSaldo(saldoActual);
            cuenta.setSaldoInicial(saldoActual);
        }else if ("deposito".equalsIgnoreCase(movimiento.getTipoMovimiento())){
            BigDecimal saldoActual = cuenta.getSaldoInicial().add(movimiento.getValor().abs());
            movimiento.setSaldo(saldoActual);
            cuenta.setSaldoInicial(saldoActual);
        }
        cuentaRepository.save(cuenta);
        movimiento.setMovimientoId(idMovimiento);
        movimientoRepository.save(mapper.mapMovimientoDTOToMovimiento(movimiento));
    }



    @Override
    public void eliminarMovimiento(Long movimientoId) {
        movimientoRepository.deleteById(movimientoId);
    }

    @Override
    public List<MovimientoDTO> getReportes(Date fechaDesde, Date fechaHasta, String identificacionCliente)
            throws Exception {
        List<MovimientoDTO> movimientoDTOList = new ArrayList<>();
        List<Movimiento> movimientos = movimientoRepository.getReporteCuenta(fechaDesde,
                fechaHasta,identificacionCliente).orElse(null);
        if (movimientos == null){
            throw new Exception("No hay movimientos realizados para estas fechas o este cliente");
        }
        for(Movimiento movimiento:movimientos){
            movimientoDTOList.add(mapper.mapMovimientoToMovimientoDTO(movimiento));
        }
        return movimientoDTOList;
    }

}
