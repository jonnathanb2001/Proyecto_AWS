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
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int id_persona;

    //@Size(min = 3, max = 10, message = "El usuario debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "La cedula no puede estar en blanco")
    @Column(name = "cedula")
    private String cedula;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido")
    private String apellido;

    @NotBlank(message = "El correo no puede estar en blanco")
    @Column(name = "correo")
    private String telefono;

    @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "direccion")
    private String direccion;

    @NotBlank(message = "Fecha de Nacimiento no puede estar en blanco")
    @Column(name = "fechanacimiento")
    private String fechanacimiento;

    @NotBlank(message = "La instruccion no puede estar en blanco")
    @Column(name = "instruccion")
    private String instruccion;

    @NotBlank(message = "El celular no puede estar en blanco")
    @Column(name = "ceular")
    private String celular;

    @JsonIgnore //si no sale los datos en swagger es por la falta de este json
    @OneToMany(mappedBy = "persona")
    private List<Usuario> listaUsuarios;

}
