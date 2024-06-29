package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.ComprobantePagoDto;
import com.home.demo.entity.ComprobantePagoEntity;
import com.home.demo.service.ComprobantePagoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comprobantes")
public class ComprobantePagoController {

    @Autowired
    private ComprobantePagoService comprobantePagoService;

    // Crear un nuevo comprobante de pago
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ComprobantePagoDto comprobantePagoDto) {
        ComprobantePagoEntity comprobantePago = new ComprobantePagoEntity();
        comprobantePago.setFechaComprobantePago(comprobantePagoDto.getFechaComprobantePago());
        comprobantePago.setNombre_comprobante(comprobantePagoDto.getNombreComprobante());
        comprobantePago.setOp_gravada(comprobantePagoDto.getOpGravada());
        comprobantePago.setIgv(comprobantePagoDto.getIgv());

        comprobantePagoService.save(comprobantePago);
        return new ResponseEntity<>("Comprobante de pago creado exitosamente", HttpStatus.CREATED);
    }

    // Obtener todos los comprobantes de pago
    @GetMapping("/all")
    public ResponseEntity<List<ComprobantePagoDto>> getAllComprobantes() {
        List<ComprobantePagoEntity> comprobantes = comprobantePagoService.findAll();
        List<ComprobantePagoDto> comprobantesDto = comprobantes.stream()
            .map(comprobante -> new ComprobantePagoDto(
                comprobante.getIdComprobantePago(),
                comprobante.getFechaComprobantePago(),
                comprobante.getNombre_comprobante(),
                comprobante.getOp_gravada(),
                comprobante.getIgv()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(comprobantesDto, HttpStatus.OK);
    }

    // Obtener un comprobante de pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getComprobanteById(@PathVariable int id) {
        Optional<ComprobantePagoEntity> comprobanteOptional = comprobantePagoService.findById(id);
        if (comprobanteOptional.isPresent()) {
            ComprobantePagoEntity comprobante = comprobanteOptional.get();
            ComprobantePagoDto comprobanteDto = new ComprobantePagoDto(
                comprobante.getIdComprobantePago(),
                comprobante.getFechaComprobantePago(),
                comprobante.getNombre_comprobante(),
                comprobante.getOp_gravada(),
                comprobante.getIgv());
            return new ResponseEntity<>(comprobanteDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Comprobante de pago no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un comprobante de pago por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateComprobante(@PathVariable int id, @RequestBody ComprobantePagoDto comprobantePagoDto) {
        Optional<ComprobantePagoEntity> comprobanteOptional = comprobantePagoService.findById(id);
        if (comprobanteOptional.isPresent()) {
            ComprobantePagoEntity comprobante = comprobanteOptional.get();
            comprobante.setFechaComprobantePago(comprobantePagoDto.getFechaComprobantePago());
            comprobante.setNombre_comprobante(comprobantePagoDto.getNombreComprobante());
            comprobante.setOp_gravada(comprobantePagoDto.getOpGravada());
            comprobante.setIgv(comprobantePagoDto.getIgv());

            comprobantePagoService.save(comprobante);
            return new ResponseEntity<>("Comprobante de pago actualizado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Comprobante de pago no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un comprobante de pago por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComprobante(@PathVariable int id) {
        Optional<ComprobantePagoEntity> comprobanteOptional = comprobantePagoService.findById(id);
        if (comprobanteOptional.isPresent()) {
            comprobantePagoService.deleteById(id);
            return new ResponseEntity<>("Comprobante de pago eliminado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Comprobante de pago no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
