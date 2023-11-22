package com.ineutm.backend.evaluaciones.expose.entities.dto;

import com.ineutm.backend.evaluaciones.expose.entities.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoDto implements Serializable {

    private int id;
    private String descripcion;
    private double intereses;
}
