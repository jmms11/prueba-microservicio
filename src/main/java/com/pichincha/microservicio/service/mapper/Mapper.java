package com.pichincha.microservicio.service.mapper;

import com.pichincha.microservicio.entity.Cliente;
import com.pichincha.microservicio.entity.Cuenta;
import com.pichincha.microservicio.entity.Movimiento;
import com.pichincha.microservicio.service.dto.ClienteDTO;
import com.pichincha.microservicio.service.dto.CuentaDTO;
import com.pichincha.microservicio.service.dto.MovimientoDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public CuentaDTO mapCuentaToCuentaDTO (Cuenta cuenta){
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setCuentaId(cuenta.getCuentaId());
        cuentaDTO.setEstado(cuenta.getEstado());
        cuentaDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaDTO.setTipoCuenta(cuenta.getTipoCuenta());
        cuentaDTO.setSaldoInicial(cuenta.getSaldoInicial());
        cuentaDTO.setNombreCliente(cuenta.getCliente().getNombre());
        cuentaDTO.setIdCliente(cuenta.getCliente().getClienteId());
        return cuentaDTO;
    }
    public Cuenta mapCuentaDTOToCuenta (CuentaDTO cuentaDTO){
        Cuenta cuenta = new Cuenta();
        cuenta.setCuentaId(cuentaDTO.getCuentaId());
        cuenta.setEstado(cuentaDTO.getEstado());
        cuenta.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        cuenta.setTipoCuenta(cuentaDTO.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaDTO.getSaldoInicial());
        cuenta.setCliente(new Cliente());
        cuenta.getCliente().setClienteId(cuentaDTO.getIdCliente());
        return cuenta;
    }

    public MovimientoDTO mapMovimientoToMovimientoDTO (Movimiento movimiento){
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        movimientoDTO.setMovimientoId(movimiento.getMovimientoId());
        movimientoDTO.setFecha(movimiento.getFecha());
        movimientoDTO.setTipoMovimiento(movimiento.getTipoMovimiento());
        movimientoDTO.setValor(movimiento.getValor());
        movimientoDTO.setSaldo(movimiento.getSaldo());
        movimientoDTO.setIdCuenta(movimiento.getCuenta().getCuentaId());
        movimientoDTO.setNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());
        movimientoDTO.setIdCliente(movimiento.getCuenta().getCliente().getClienteId());
        movimientoDTO.setNombreCliente(movimiento.getCuenta().getCliente().getNombre());
        return movimientoDTO;
    }

    public Movimiento mapMovimientoDTOToMovimiento (MovimientoDTO movimientoDTO){
        Movimiento movimiento = new Movimiento();
        movimiento.setMovimientoId(movimientoDTO.getMovimientoId());
        movimiento.setFecha(movimientoDTO.getFecha());
        movimiento.setTipoMovimiento(movimientoDTO.getTipoMovimiento());
        movimiento.setValor(movimientoDTO.getValor());
        movimiento.setSaldo(movimientoDTO.getSaldo());
        movimiento.setCuenta(new Cuenta());
        movimiento.getCuenta().setCuentaId(movimientoDTO.getIdCuenta());
        movimiento.getCuenta().setCliente(new Cliente());
        movimiento.getCuenta().getCliente().setClienteId(movimientoDTO.getIdCliente());
        return movimiento;
    }

    public ClienteDTO mapClienteToClienteDTO (Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setClienteId(cliente.getClienteId());
        clienteDTO.setContrasena(cliente.getContrasena());
        clienteDTO.setEstado(cliente.getEstado());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setGenero(cliente.getGenero());
        clienteDTO.setEdad(cliente.getEdad());
        clienteDTO.setIdentificacion(cliente.getIdentificacion());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setTelefono(cliente.getTelefono());
        return clienteDTO;
    }

    public Cliente mapClienteDTOToCliente (ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setClienteId(clienteDTO.getClienteId());
        cliente.setContrasena(clienteDTO.getContrasena());
        cliente.setEstado(clienteDTO.getEstado());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setGenero(clienteDTO.getGenero());
        cliente.setEdad(clienteDTO.getEdad());
        cliente.setIdentificacion(clienteDTO.getIdentificacion());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setTelefono(clienteDTO.getTelefono());
        return cliente;
    }

}
