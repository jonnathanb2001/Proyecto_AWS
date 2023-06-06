/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;

/**
 *
 * @author jonny
 */
@Data
@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int id_usuario;

    //@Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String tipo;

    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Column(name = "descripcion")
    private String descripcion;

    @NotBlank(message = "El estado usuario no puede estar en blanco")
    @Column(name = "estado")
    private String estado;
    
    @JsonIgnore //si no sale los datos en swagger es por la falta de este json
    @OneToMany(mappedBy = "rol")
    private List<Usuario> listaUsuarios;

}
