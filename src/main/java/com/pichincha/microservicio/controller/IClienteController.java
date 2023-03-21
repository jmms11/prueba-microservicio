package com.pichincha.microservicio.controller;

import com.pichincha.microservicio.entity.Cliente;
import com.pichincha.microservicio.service.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IClienteController {
    /**
     * @param idCliente
     * @return ResponseEntity<Object>
     */
    public ResponseEntity<Object> getClienteById(Long idCliente) throws Exception;

    /**
     * @return ResponseEntity<Object>
     */
    public ResponseEntity<List<ClienteDTO>> getListClientes() throws Exception;

    /**
     * @param cliente
     * @return ResponseEntity<Object>
     */
    public ResponseEntity<String> createCliente(ClienteDTO cliente);

    /**
     * @param cliente
     * @return ResponseEntity<String>
     */
    public ResponseEntity<String> updateCliente(Long idCliente,ClienteDTO cliente);

    /**
     * @param idCliente
     * @return ResponseEntity<Object>
     */
    public ResponseEntity<String> deleteClienteById(Long idCliente);

}
