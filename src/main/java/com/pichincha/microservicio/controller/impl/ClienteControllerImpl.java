package com.pichincha.microservicio.controller.impl;

import com.pichincha.microservicio.controller.IClienteController;
import com.pichincha.microservicio.entity.Cliente;
import com.pichincha.microservicio.service.IClienteService;
import com.pichincha.microservicio.service.dto.ClienteDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
@Slf4j
public class ClienteControllerImpl implements IClienteController {

    @Autowired
    IClienteService clienteService;

    @Override
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getListClientes() throws Exception {
        log.info("Inicio: getListClientes");
        return ResponseEntity.ok(clienteService.getListClientes());
    }

    @Override
    @GetMapping("/{idCliente}")
    public ResponseEntity<Object> getClienteById(@PathVariable Long idCliente) throws Exception {
        log.info("Inicio: getClienteById", idCliente);
        return new ResponseEntity<Object> (clienteService.getClienteById(idCliente),HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<String> createCliente(@RequestBody ClienteDTO cliente) {
        log.info("Inicio: createCliente", cliente);
        ClienteDTO clienteCreado = clienteService.crearCliente(cliente);
        log.info("Fin: createCliente", clienteCreado);
        return new ResponseEntity<String>("Cliente creado correctamente con el id: "+ clienteCreado.getClienteId(), HttpStatus.CREATED);
    }

    @Override
    @PatchMapping("/{idCliente}")
    public ResponseEntity<String> updateCliente(@PathVariable Long idCliente,@RequestBody ClienteDTO cliente) {
        log.info("Inicio: updateCliente", cliente);
        clienteService.actualizarCliente(idCliente,cliente);
        log.info("Fin: updateCliente");
        return new ResponseEntity<String>("Cliente actualizado correctamente con el id: " + idCliente, HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<String> deleteClienteById(@PathVariable Long idCliente) {
        log.info("Inicio: deleteClienteById", idCliente);
        clienteService.eliminarCliente(idCliente);
        return new ResponseEntity<String> ("Cliente eliminado correctamente",HttpStatus.OK);
    }
}
