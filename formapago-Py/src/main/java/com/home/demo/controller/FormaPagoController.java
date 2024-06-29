package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.FormaPagoDto;
import com.home.demo.entity.FormaPagoEntity;
import com.home.demo.service.FormaPagoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/formaspago")
public class FormaPagoController {

    @Autowired
    private FormaPagoService formaPagoService;

    // Crear una nueva forma de pago
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody FormaPagoDto formaPagoDto) {
        FormaPagoEntity formaPago = new FormaPagoEntity();
        formaPago.setNombreFormapago(formaPagoDto.getNombreFormapago());
        formaPagoService.save(formaPago);
        return new ResponseEntity<>("Forma de pago creada exitosamente", HttpStatus.CREATED);
    }

    // Obtener todas las formas de pago
    @GetMapping("/all")
    public ResponseEntity<List<FormaPagoDto>> getAllFormasPago() {
        List<FormaPagoEntity> formasPago = formaPagoService.findAll();
        List<FormaPagoDto> formasPagoDto = formasPago.stream()
            .map(formaPago -> new FormaPagoDto(formaPago.getIdFormapago(), formaPago.getNombreFormapago()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(formasPagoDto, HttpStatus.OK);
    }

    // Obtener una forma de pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getFormaPagoById(@PathVariable int id) {
        Optional<FormaPagoEntity> formaPagoOptional = formaPagoService.findById(id);
        if (formaPagoOptional.isPresent()) {
            FormaPagoEntity formaPago = formaPagoOptional.get();
            FormaPagoDto formaPagoDto = new FormaPagoDto(formaPago.getIdFormapago(), formaPago.getNombreFormapago());
            return new ResponseEntity<>(formaPagoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forma de pago no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar una forma de pago por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFormaPago(@PathVariable int id, @RequestBody FormaPagoDto formaPagoDto) {
        Optional<FormaPagoEntity> formaPagoOptional = formaPagoService.findById(id);
        if (formaPagoOptional.isPresent()) {
            FormaPagoEntity formaPago = formaPagoOptional.get();
            formaPago.setNombreFormapago(formaPagoDto.getNombreFormapago());
            formaPagoService.save(formaPago);
            return new ResponseEntity<>("Forma de pago actualizada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forma de pago no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una forma de pago por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFormaPago(@PathVariable int id) {
        Optional<FormaPagoEntity> formaPagoOptional = formaPagoService.findById(id);
        if (formaPagoOptional.isPresent()) {
            formaPagoService.deleteById(id);
            return new ResponseEntity<>("Forma de pago eliminada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forma de pago no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
