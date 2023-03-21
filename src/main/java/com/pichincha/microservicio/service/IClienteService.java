package com.pichincha.microservicio.service;

import com.pichincha.microservicio.entity.Cliente;
import com.pichincha.microservicio.service.dto.ClienteDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteService {
    List<ClienteDTO> getListClientes() throws Exception;

    ClienteDTO getClienteById(Long idCliente) throws Exception;

    ClienteDTO crearCliente(ClienteDTO cliente);

    void actualizarCliente(Long idCliente, ClienteDTO cliente);

    void eliminarCliente(Long idCliente);


}
