package com.ineutm.backend.evaluaciones.expose.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUENTA")
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int estado;
    @Basic(optional = false)
    private String numero;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    @JsonIgnore
    private Usuario usuario;
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Movimiento> movimientos;


}
