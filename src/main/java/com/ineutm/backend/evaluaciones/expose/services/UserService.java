package com.ineutm.backend.evaluaciones.expose.services;

import com.ineutm.backend.evaluaciones.expose.entities.Usuario;
import com.ineutm.backend.evaluaciones.expose.entities.dto.UsuarioDto;
import com.ineutm.backend.evaluaciones.expose.repositories.UserRepository;
import com.ineutm.backend.evaluaciones.expose.utils.MapStructMapper;
import com.ineutm.backend.evaluaciones.expose.utils.MapStructMapperImpl;
import com.ineutm.backend.evaluaciones.expose.utils.Util;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final MapStructMapper mapStructMapper;

    private final AccountService accountService;
    private final UserRepository userRepository;
    private final MovementService movementService;

    public UserService(AccountService accountService, UserRepository userRepository, MovementService movementService) {
        this.accountService = accountService;
        this.userRepository = userRepository;
        this.movementService = movementService;
        this.mapStructMapper = new MapStructMapperImpl();
    }


    public Mono<UsuarioDto> findUserById(int userId){
        Usuario usuario = userRepository.findById(userId).orElse(null);
        if (usuario==null){
            throw  new RuntimeException("the Record no exist");
        }
        return  Mono.justOrEmpty(mapStructMapper.UsuarioToUsuarioDto(usuario));
    }

    public Mono<UsuarioDto> findUserByDni(String dni){
        dni = Util.constructDni(dni);
        Usuario usuario = userRepository.findByUsuarioDni(dni);
        if (usuario==null){
            throw  new RuntimeException("the Record no exist");
        }
        return  Mono.justOrEmpty(mapStructMapper.UsuarioToUsuarioDto(usuario));
    }

    public Mono<UsuarioDto> findUserCompleteById(int userId){
        // Obtiene un Mono de UsuarioDto a partir del servicio userService
        return findUserById(userId).flatMap(usuario ->
                // Obtiene las cuentas asociadas al usuario y las asigna al usuario
                accountService.getAccountByIdUsuario(usuario.getId())
                        .collectList()
                        .map(cuentas -> {
                            usuario.setCuentas(cuentas);
                            return usuario;
                        })
                        // Si el usuario es "PREMIUM", busca los movimientos de las cuentas
                        .flatMap(user -> {
                            if ("PREMIUM".equals(user.getTipo())) {
                                return Flux.fromIterable(user.getCuentas())
                                        // Obtiene los movimientos de cada cuenta
                                        .flatMap(cuenta ->
                                                movementService.findMoviminetoByIdCuenta(cuenta.getId())
                                                        .collectList()
                                                        .map(movimientos -> {
                                                            // Asigna los movimientos a la cuenta
                                                            cuenta.setMovimientos(movimientos);
                                                            return cuenta;
                                                        }))
                                        // Agrupa las cuentas con sus movimientos
                                        .collectList()
                                        .map(cuentasConMovimientos -> {
                                            // Asigna las cuentas con movimientos al usuario
                                            user.setCuentasDto(cuentasConMovimientos);
                                            return user;
                                        });
                            } else {
                                // Si el usuario no es "PREMIUM", retorna el usuario sin cambios
                                return Mono.just(user);
                            }
                        })
        );
    }
}
