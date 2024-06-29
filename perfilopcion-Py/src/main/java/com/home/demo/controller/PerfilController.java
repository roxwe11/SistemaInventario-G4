package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.PerfilDto;
import com.home.demo.entity.PerfilEntity;
import com.home.demo.service.PerfilService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    // Crear un nuevo perfil
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PerfilDto perfilDto) {
        PerfilEntity perfil = new PerfilEntity();
        perfil.setNombrePerfil(perfilDto.getNombrePerfil());
        perfil.setDescripcion(perfilDto.getDescripcion());

        perfilService.save(perfil);
        return new ResponseEntity<>("Perfil creado exitosamente", HttpStatus.CREATED);
    }

    // Obtener todos los perfiles
    @GetMapping("/all")
    public ResponseEntity<List<PerfilDto>> getAllPerfiles() {
        List<PerfilEntity> perfiles = perfilService.findAll();
        List<PerfilDto> perfilesDto = perfiles.stream()
            .map(perfil -> new PerfilDto(
                perfil.getIdPerfil(),
                perfil.getNombrePerfil(),
                perfil.getDescripcion()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(perfilesDto, HttpStatus.OK);
    }

    // Obtener un perfil por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPerfilById(@PathVariable int id) {
        Optional<PerfilEntity> perfilOptional = perfilService.findById(id);
        if (perfilOptional.isPresent()) {
            PerfilEntity perfil = perfilOptional.get();
            PerfilDto perfilDto = new PerfilDto(
                perfil.getIdPerfil(),
                perfil.getNombrePerfil(),
                perfil.getDescripcion());
            return new ResponseEntity<>(perfilDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Perfil no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un perfil por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePerfil(@PathVariable int id, @RequestBody PerfilDto perfilDto) {
        Optional<PerfilEntity> perfilOptional = perfilService.findById(id);
        if (perfilOptional.isPresent()) {
            PerfilEntity perfil = perfilOptional.get();
            perfil.setNombrePerfil(perfilDto.getNombrePerfil());
            perfil.setDescripcion(perfilDto.getDescripcion());

            perfilService.save(perfil);
            return new ResponseEntity<>("Perfil actualizado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Perfil no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un perfil por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerfil(@PathVariable int id) {
        Optional<PerfilEntity> perfilOptional = perfilService.findById(id);
        if (perfilOptional.isPresent()) {
            perfilService.deleteById(id);
            return new ResponseEntity<>("Perfil eliminado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Perfil no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
