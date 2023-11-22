package com.ineutm.backend.evaluaciones.expose.repositories;

import com.ineutm.backend.evaluaciones.expose.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Cuenta, Integer> {

    @Query("SELECT c FROM Cuenta c WHERE c.usuario.id = :id")
    List<Cuenta> findByUsuarioId(int id);
}
