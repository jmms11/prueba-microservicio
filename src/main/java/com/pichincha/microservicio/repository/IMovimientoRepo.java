package com.pichincha.microservicio.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pichincha.microservicio.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientoRepo extends JpaRepository<Movimiento, Long> {

    Optional<Movimiento> findByMovimientoId(Long movimientoId);

    @Query(value = "SELECT * FROM (banca.MOVIMIENTO mo INNER JOIN banca.CUENTA cu ON mo.cuenta_id = cu.cuenta_id)" +
            " INNER JOIN banca.CLIENTE cl  ON cu.cliente_id=cl.cliente_id" +
            " AND mo.fecha BETWEEN :fechaDesde AND :fechaHasta " +
            " AND cl.identificacion= :identificacion", nativeQuery = true)
    Optional<List<Movimiento>> getReporteCuenta(@Param("fechaDesde") Date fechaDesde,
                                                                   @Param("fechaHasta") Date fechaHasta,
                                                                   @Param("identificacion") String identificacion);

}
