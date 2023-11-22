package com.ineutm.backend.evaluaciones.expose.repositories;

import com.ineutm.backend.evaluaciones.expose.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movimiento, Integer> {

    @Query("SELECT m FROM Movimiento m WHERE m.cuenta.id = :cuentaid")
    List<Movimiento> findByCuentaId(int cuentaid);
}
