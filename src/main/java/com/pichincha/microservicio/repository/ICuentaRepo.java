package com.pichincha.microservicio.repository;

import java.util.Optional;


import com.pichincha.microservicio.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuentaRepo extends JpaRepository<Cuenta, Long> {

        Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

        Optional<Cuenta> findByCuentaId(Long cuentaId);

}
