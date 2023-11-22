package com.ineutm.backend.evaluaciones.expose.repositories;

import com.ineutm.backend.evaluaciones.expose.entities.Cuenta;
import com.ineutm.backend.evaluaciones.expose.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.numerodocumento = :id")
    Usuario findByUsuarioDni(String id);
}
