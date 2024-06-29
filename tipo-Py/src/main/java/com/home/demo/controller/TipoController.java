package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.TipoDto;
import com.home.demo.entity.TipoEntity;
import com.home.demo.service.TipoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    // Crear un nuevo tipo
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TipoDto tipoDto) {
        TipoEntity tipo = new TipoEntity();
        tipo.setNombreTipo(tipoDto.getNombreTipo());
        tipo.setDetalleTipo(tipoDto.getDetalleTipo());

        tipoService.save(tipo);
        return new ResponseEntity<>("Tipo creado exitosamente", HttpStatus.CREATED);
    }

    // Obtener todos los tipos
    @GetMapping("/all")
    public ResponseEntity<List<TipoDto>> getAllTipos() {
        List<TipoEntity> tipos = tipoService.findAll();
        List<TipoDto> tiposDto = tipos.stream()
            .map(tipo -> new TipoDto(
                tipo.getIdTipo(),
                tipo.getNombreTipo(),
                tipo.getDetalleTipo()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(tiposDto, HttpStatus.OK);
    }

    // Obtener un tipo por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getTipoById(@PathVariable int id) {
        Optional<TipoEntity> tipoOptional = tipoService.findById(id);
        if (tipoOptional.isPresent()) {
            TipoEntity tipo = tipoOptional.get();
            TipoDto tipoDto = new TipoDto(
                tipo.getIdTipo(),
                tipo.getNombreTipo(),
                tipo.getDetalleTipo());
            return new ResponseEntity<>(tipoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tipo no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un tipo por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTipo(@PathVariable int id, @RequestBody TipoDto tipoDto) {
        Optional<TipoEntity> tipoOptional = tipoService.findById(id);
        if (tipoOptional.isPresent()) {
            TipoEntity tipo = tipoOptional.get();
            tipo.setNombreTipo(tipoDto.getNombreTipo());
            tipo.setDetalleTipo(tipoDto.getDetalleTipo());

            tipoService.save(tipo);
            return new ResponseEntity<>("Tipo actualizado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tipo no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un tipo por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTipo(@PathVariable int id) {
        Optional<TipoEntity> tipoOptional = tipoService.findById(id);
        if (tipoOptional.isPresent()) {
            tipoService.deleteById(id);
            return new ResponseEntity<>("Tipo eliminado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tipo no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
