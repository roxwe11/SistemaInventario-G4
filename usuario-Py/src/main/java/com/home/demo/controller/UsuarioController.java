package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.UsuarioDto;
import com.home.demo.entity.UsuarioEntity;
import com.home.demo.service.UsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Crear un nuevo usuario
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setContraseña(usuarioDto.getContraseña());

        usuarioService.save(usuario);
        return new ResponseEntity<>("Usuario creado exitosamente", HttpStatus.CREATED);
    }

    // Obtener todos los usuarios
    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
        List<UsuarioEntity> usuarios = usuarioService.findAll();
        List<UsuarioDto> usuariosDto = usuarios.stream()
            .map(usuario -> new UsuarioDto(
                usuario.getIdUsuario(),
                usuario.getNombreUsuario(),
                usuario.getContraseña()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(usuariosDto, HttpStatus.OK);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable int id) {
        Optional<UsuarioEntity> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            UsuarioEntity usuario = usuarioOptional.get();
            UsuarioDto usuarioDto = new UsuarioDto(
                usuario.getIdUsuario(),
                usuario.getNombreUsuario(),
                usuario.getContraseña());
            return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un usuario por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable int id, @RequestBody UsuarioDto usuarioDto) {
        Optional<UsuarioEntity> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            UsuarioEntity usuario = usuarioOptional.get();
            usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
            usuario.setContraseña(usuarioDto.getContraseña());

            usuarioService.save(usuario);
            return new ResponseEntity<>("Usuario actualizado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
        Optional<UsuarioEntity> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            usuarioService.deleteById(id);
            return new ResponseEntity<>("Usuario eliminado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
