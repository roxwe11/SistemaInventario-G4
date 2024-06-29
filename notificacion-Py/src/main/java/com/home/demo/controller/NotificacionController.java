package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.NotificacionDto;
import com.home.demo.entity.NotificacionEntity;
import com.home.demo.service.NotificacionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    // Crear una nueva notificación
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NotificacionDto notificacionDto) {
        NotificacionEntity notificacion = new NotificacionEntity();
        notificacion.setMensaje(notificacionDto.getMensaje());
        notificacion.setFecha_notificacion(notificacionDto.getFecha_notificacion());
        notificacion.setTipo_notificacion(notificacionDto.getTipo_notificacion());
        notificacionService.save(notificacion);
        return new ResponseEntity<>("Notificación creada exitosamente", HttpStatus.CREATED);
    }

    // Obtener todas las notificaciones
    @GetMapping("/all")
    public ResponseEntity<List<NotificacionDto>> getAllNotificaciones() {
        List<NotificacionEntity> notificaciones = notificacionService.findAll();
        List<NotificacionDto> notificacionesDto = notificaciones.stream()
            .map(notificacion -> new NotificacionDto(
                notificacion.getIdNotificacion(),
                notificacion.getMensaje(),
                notificacion.getFecha_notificacion(),
                notificacion.getTipo_notificacion()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(notificacionesDto, HttpStatus.OK);
    }

    // Obtener una notificación por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getNotificacionById(@PathVariable int id) {
        Optional<NotificacionEntity> notificacionOptional = notificacionService.findById(id);
        if (notificacionOptional.isPresent()) {
            NotificacionEntity notificacion = notificacionOptional.get();
            NotificacionDto notificacionDto = new NotificacionDto(
                notificacion.getIdNotificacion(),
                notificacion.getMensaje(),
                notificacion.getFecha_notificacion(),
                notificacion.getTipo_notificacion());
            return new ResponseEntity<>(notificacionDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Notificación no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar una notificación por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNotificacion(@PathVariable int id, @RequestBody NotificacionDto notificacionDto) {
        Optional<NotificacionEntity> notificacionOptional = notificacionService.findById(id);
        if (notificacionOptional.isPresent()) {
            NotificacionEntity notificacion = notificacionOptional.get();
            notificacion.setMensaje(notificacionDto.getMensaje());
            notificacion.setFecha_notificacion(notificacionDto.getFecha_notificacion());
            notificacion.setTipo_notificacion(notificacionDto.getTipo_notificacion());
            notificacionService.save(notificacion);
            return new ResponseEntity<>("Notificación actualizada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Notificación no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una notificación por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotificacion(@PathVariable int id) {
        Optional<NotificacionEntity> notificacionOptional = notificacionService.findById(id);
        if (notificacionOptional.isPresent()) {
            notificacionService.deleteById(id);
            return new ResponseEntity<>("Notificación eliminada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Notificación no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
