package com.pichincha.microservicio.service.impl;


import com.pichincha.microservicio.entity.Cliente;
import com.pichincha.microservicio.repository.IClienteRepo;
import com.pichincha.microservicio.service.IClienteService;
import com.pichincha.microservicio.service.dto.ClienteDTO;
import com.pichincha.microservicio.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private IClienteRepo clienteRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<ClienteDTO> getListClientes() throws Exception{
        List<ClienteDTO> clienteDTOS = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findAll();
        if (clientes == null){
            throw new Exception("No existen clientes");
        }
        for (Cliente cliente: clientes) {
            clienteDTOS.add(mapper.mapClienteToClienteDTO(cliente));
        }
        return clienteDTOS;
    }

    @Override
    public ClienteDTO getClienteById(Long idCliente) throws Exception{
        Cliente cliente = clienteRepository.findByClienteId(idCliente).orElse(null);
        if (cliente == null){
            throw new Exception("El cliente no existe");
        }
        return mapper.mapClienteToClienteDTO(cliente);
    }

    @Override
    public ClienteDTO crearCliente(ClienteDTO cliente) {
        Cliente clienteCreado = clienteRepository.save(mapper.mapClienteDTOToCliente(cliente));
        cliente.setClienteId(clienteCreado.getClienteId());
        return cliente;
    }

    @Override
    public void actualizarCliente(Long idCliente, ClienteDTO cliente) {
        cliente.setClienteId(idCliente);
        clienteRepository.save(mapper.mapClienteDTOToCliente(cliente));
    }

    @Override
    public void eliminarCliente(Long idCliente) { clienteRepository.deleteById(idCliente);
    }
}
