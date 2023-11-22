package com.ineutm.backend.evaluaciones.expose.services;

import com.ineutm.backend.evaluaciones.expose.entities.Movimiento;
import com.ineutm.backend.evaluaciones.expose.repositories.MovementRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MovementService {
    private final MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Flux<Movimiento> findMoviminetoByIdCuenta(int idCuenta){
        return  Flux.fromIterable(movementRepository.findByCuentaId(idCuenta));
    }
}
