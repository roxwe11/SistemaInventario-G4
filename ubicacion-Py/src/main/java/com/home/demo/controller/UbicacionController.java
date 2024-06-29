package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.UbicacionDto;
import com.home.demo.entity.UbicacionEntity;
import com.home.demo.service.UbicacionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    // Crear una nueva ubicación
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UbicacionDto ubicacionDto) {
        UbicacionEntity ubicacion = new UbicacionEntity();
        ubicacion.setNombre_ubicacion(ubicacionDto.getNombreUbicacion());

        ubicacionService.save(ubicacion);
        return new ResponseEntity<>("Ubicación creada exitosamente", HttpStatus.CREATED);
    }

    // Obtener todas las ubicaciones
    @GetMapping("/all")
    public ResponseEntity<List<UbicacionDto>> getAllUbicaciones() {
        List<UbicacionEntity> ubicaciones = ubicacionService.findAll();
        List<UbicacionDto> ubicacionesDto = ubicaciones.stream()
            .map(ubicacion -> new UbicacionDto(
                ubicacion.getIdUbicacion(),
                ubicacion.getNombre_ubicacion()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(ubicacionesDto, HttpStatus.OK);
    }

    // Obtener una ubicación por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUbicacionById(@PathVariable int id) {
        Optional<UbicacionEntity> ubicacionOptional = ubicacionService.findById(id);
        if (ubicacionOptional.isPresent()) {
            UbicacionEntity ubicacion = ubicacionOptional.get();
            UbicacionDto ubicacionDto = new UbicacionDto(
                ubicacion.getIdUbicacion(),
                ubicacion.getNombre_ubicacion());
            return new ResponseEntity<>(ubicacionDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ubicación no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar una ubicación por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUbicacion(@PathVariable int id, @RequestBody UbicacionDto ubicacionDto) {
        Optional<UbicacionEntity> ubicacionOptional = ubicacionService.findById(id);
        if (ubicacionOptional.isPresent()) {
            UbicacionEntity ubicacion = ubicacionOptional.get();
            ubicacion.setNombre_ubicacion(ubicacionDto.getNombreUbicacion());

            ubicacionService.save(ubicacion);
            return new ResponseEntity<>("Ubicación actualizada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ubicación no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una ubicación por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUbicacion(@PathVariable int id) {
        Optional<UbicacionEntity> ubicacionOptional = ubicacionService.findById(id);
        if (ubicacionOptional.isPresent()) {
            ubicacionService.deleteById(id);
            return new ResponseEntity<>("Ubicación eliminada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ubicación no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
