package com.ineutm.backend.evaluaciones.expose.utils;

import com.ineutm.backend.evaluaciones.expose.entities.Cuenta;
import com.ineutm.backend.evaluaciones.expose.entities.Movimiento;
import com.ineutm.backend.evaluaciones.expose.entities.Usuario;
import com.ineutm.backend.evaluaciones.expose.entities.dto.CuentaDto;
import com.ineutm.backend.evaluaciones.expose.entities.dto.MovimientoDto;
import com.ineutm.backend.evaluaciones.expose.entities.dto.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapStructMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "cuentas", target = "cuentas", ignore = true)
    UsuarioDto UsuarioToUsuarioDto(Usuario usuario);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "movimientos", target = "movimientos", ignore = true)
    CuentaDto CuentaToCuentaDto(Cuenta cuenta);
    @Mapping(source = "id", target = "id")
    MovimientoDto MovimientoToMovimientoDto(Movimiento movimiento);
}
