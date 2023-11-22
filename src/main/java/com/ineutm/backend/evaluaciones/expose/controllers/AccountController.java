package com.ineutm.backend.evaluaciones.expose.controllers;

import com.ineutm.backend.evaluaciones.expose.entities.Cuenta;
import com.ineutm.backend.evaluaciones.expose.entities.dto.RequestDto;
import com.ineutm.backend.evaluaciones.expose.entities.dto.UsuarioDto;
import com.ineutm.backend.evaluaciones.expose.services.AccountService;
import com.ineutm.backend.evaluaciones.expose.services.MovementService;
import com.ineutm.backend.evaluaciones.expose.services.UserService;
import com.ineutm.backend.evaluaciones.expose.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/account")
@Slf4j
public class AccountController {
  private final UserService userService;
  public AccountController( UserService userService) {

    this.userService = userService;
  }
  @GetMapping("/{user-identity}")
  public ResponseEntity<?> getAllAccounts(@PathVariable("user-identity") int userIdentity) {
    try {
      Mono<UsuarioDto> dtoMono = userService.findUserCompleteById(userIdentity);
      return new ResponseEntity<>(dtoMono, HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/findAllAccounts")
  public ResponseEntity<?> getAllAccountsForPost(@RequestBody RequestDto dto){
    try {
      log.info(Util.encriptFirstFourCharacter(dto.dni));
      Util.validateDniFormat(dto.dni);
      Util.validateEmailFormat(dto.correo);
      Mono<UsuarioDto> dtoMono = userService.findUserByDni(dto.dni);
      return new ResponseEntity<>(dtoMono, HttpStatus.OK);
    } catch (IllegalArgumentException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/findAllAccounts/{dni}")
  public ResponseEntity<?> getAllAccountsForGet( @RequestParam(name = "correo") String correo,@PathVariable(name = "dni") String dni){
    try {
      log.info(Util.encriptFirstFourCharacter(dni));
      Util.validateDniFormat(dni);
      Util.validateEmailFormat(correo);
      Mono<UsuarioDto> dtoMono = userService.findUserByDni(dni);
      return new ResponseEntity<>(dtoMono, HttpStatus.OK);
    } catch (IllegalArgumentException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
