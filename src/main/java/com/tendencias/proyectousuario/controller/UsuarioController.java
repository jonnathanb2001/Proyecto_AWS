/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.controller;

import com.tendencias.proyectousuario.model.Usuario;
import com.tendencias.proyectousuario.repository.UsuarioRepository;
import com.tendencias.proyectousuario.service.S3Service;
import com.tendencias.proyectousuario.service.UsuarioServiceImpl;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonny
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    S3Service s3Service;

    @GetMapping
    List<Usuario> getAll() {
        return usuarioRepository.findAll()
                .stream()
                .peek(usuario -> usuario.setFoto(s3Service.getObjectUrl(usuario.getImagenPath())))
                .collect(Collectors.toList());
    }

    @PostMapping
    Usuario create(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        usuario.setFoto(s3Service.getObjectUrl(usuario.getImagenPath()));
        return usuario;
    }

    /*

    @Operation(summary = "Se obtiene la lista de Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Usuario")
    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario u) {
        return new ResponseEntity<>(usuarioService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario u) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            try {
                usuario.setNombre(u.getNombre());
                usuario.setClave(u.getClave());
                usuario.setEstado(u.getEstado());
                usuario.setEmail(u.getEmail());
                usuario.setPersona(u.getPersona());
                usuario.setRol(u.getRol());
                return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Usuario> elimiarUsuario(@PathVariable Integer id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }¨

     */
}
