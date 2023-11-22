package com.ineutm.backend.evaluaciones.expose.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ineutm.backend.evaluaciones.expose.entities.Movimiento;
import com.ineutm.backend.evaluaciones.expose.entities.Usuario;
import com.ineutm.backend.evaluaciones.expose.utils.MapStructMapperImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuentaDto implements Serializable {

    private int id;
    private int estado;
    private String numero;
    private List<MovimientoDto> movimientos;

    public void setMovimientosDto(List<MovimientoDto> movimientos) {
        this.movimientos = movimientos;
    }
    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos.stream().map(e-> new MapStructMapperImpl().MovimientoToMovimientoDto(e)).collect(Collectors.toList());
    }
}
