package com.pichincha.microservicio.repository;

import java.util.Optional;


import com.pichincha.microservicio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByClienteId(Long clienteId);

    Optional<Cliente> findByIdentificacion(String identificacion);

}
