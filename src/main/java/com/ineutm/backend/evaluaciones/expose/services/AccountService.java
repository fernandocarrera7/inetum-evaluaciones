package com.ineutm.backend.evaluaciones.expose.services;

import com.ineutm.backend.evaluaciones.expose.entities.Cuenta;
import com.ineutm.backend.evaluaciones.expose.entities.Movimiento;
import com.ineutm.backend.evaluaciones.expose.repositories.AccountRepository;
import com.ineutm.backend.evaluaciones.expose.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    //@Autowired
    private final AccountRepository accountRepository;



   public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Flux<Cuenta> getAccountByIdUsuario(int idUsuario){
        return Flux.fromIterable(accountRepository.findByUsuarioId(idUsuario));
    }




}
