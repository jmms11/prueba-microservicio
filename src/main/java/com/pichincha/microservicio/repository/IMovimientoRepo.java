package com.pichincha.microservicio.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pichincha.microservicio.entity.Movimiento;
import com.pichincha.microservicio.service.dto.MovimientoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientoRepo extends JpaRepository<Movimiento, Long> {

    Optional<Movimiento> findByMovimientoId(Long movimientoId);

    @Query(value = "SELECT * FROM MOVIMIENTO m "
            + " WHERE m.fechaMovimiento BETWEEN :fechaDesde AND :fechaHasta "
            + " AND m.cuenta.cliente.identificacion = :identificacion ", nativeQuery = true)
    Optional<List<MovimientoDTO>> getReporteCuenta(@Param("fechaDesde") Date fechaDesde,
                                                                   @Param("fechaHasta") Date fechaHasta,
                                                                   @Param("identificacion") String identificacion);

}
