package com.pichincha.microservicio.controller;

import com.pichincha.microservicio.service.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClienteController {
    /**
     * @param idCliente
     * @return ResponseEntity<Object>
     */
    ResponseEntity<Object> getClienteById(Long idCliente) throws Exception;

    /**
     * @return ResponseEntity<Object>
     */
    ResponseEntity<List<ClienteDTO>> getListClientes() throws Exception;

    /**
     * @param cliente
     * @return ResponseEntity<Object>
     */
    ResponseEntity<String> createCliente(ClienteDTO cliente);

    /**
     * @param cliente
     * @return ResponseEntity<String>
     */
    ResponseEntity<String> updateCliente(Long idCliente,ClienteDTO cliente);

    /**
     * @param idCliente
     * @return ResponseEntity<Object>
     */
    ResponseEntity<String> deleteClienteById(Long idCliente);

}
