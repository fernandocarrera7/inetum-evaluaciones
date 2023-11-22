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
@Table(name = "USUARIO")
public class Usuario implements Serializable {
 private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 @Basic(optional = false)
 private String nombre;
 @Basic(optional = false)
 private String numerodocumento;
 private int estado;
 @Basic(optional = false)
 private String tipo;
 @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
 @JsonIgnore
 private List<Cuenta> cuentas;

}
