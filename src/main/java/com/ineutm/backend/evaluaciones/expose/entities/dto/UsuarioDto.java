package com.ineutm.backend.evaluaciones.expose.entities.dto;

import com.ineutm.backend.evaluaciones.expose.entities.Cuenta;
import com.ineutm.backend.evaluaciones.expose.utils.MapStructMapperImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto implements Serializable {

    private int id;
    private String nombre;
    private String numerodocumento;
    private int estado;
    private String tipo;
    private List<CuentaDto> cuentas;


    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas.stream().map(e-> new MapStructMapperImpl().CuentaToCuentaDto(e)).collect(Collectors.toList());
    }
    public void setCuentasDto(List<CuentaDto> cuentas) {
        this.cuentas = cuentas;
    }
}
