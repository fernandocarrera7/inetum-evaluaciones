package com.ineutm.backend.evaluaciones.expose.entities.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RequestDto implements Serializable {

    @Schema(description = "dni del usuario debe ser de 8 digitos numericos")
    public String dni;
    @Schema(description = "el correo del usuario debe ser del formato xxx@inetum.com.pe")
    public String correo;

    public RequestDto() {
    }

    public RequestDto(String dni, String correo) {
        this.dni = dni;
        this.correo = correo;
    }
}
