package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.VentaDto;
import com.home.demo.entity.VentaEntity;
import com.home.demo.service.VentaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // Crear una nueva venta
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VentaDto ventaDto) {
        VentaEntity venta = new VentaEntity(ventaDto.getFecha_venta(), ventaDto.getTotalventa());
        ventaService.save(venta);
        return new ResponseEntity<>("Venta creada exitosamente", HttpStatus.CREATED);
    }

    // Obtener todas las ventas
    @GetMapping("/all")
    public ResponseEntity<List<VentaDto>> getAllVentas() {
        List<VentaEntity> ventas = ventaService.findAll();
        List<VentaDto> ventasDto = ventas.stream()
            .map(venta -> new VentaDto(venta.getFecha_venta(), venta.getTotalventa()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(ventasDto, HttpStatus.OK);
    }

    // Obtener una venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getVentaById(@PathVariable int id) {
        Optional<VentaEntity> ventaOptional = ventaService.findById(id);
        if (ventaOptional.isPresent()) {
            VentaEntity venta = ventaOptional.get();
            VentaDto ventaDto = new VentaDto(venta.getFecha_venta(), venta.getTotalventa());
            return new ResponseEntity<>(ventaDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Venta no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar una venta por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVenta(@PathVariable int id, @RequestBody VentaDto ventaDto) {
        Optional<VentaEntity> ventaOptional = ventaService.findById(id);
        if (ventaOptional.isPresent()) {
            VentaEntity venta = ventaOptional.get();
            venta.setFecha_venta(ventaDto.getFecha_venta());
            venta.setTotalventa(ventaDto.getTotalventa());
            ventaService.save(venta);
            return new ResponseEntity<>("Venta actualizada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Venta no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una venta por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable int id) {
        Optional<VentaEntity> ventaOptional = ventaService.findById(id);
        if (ventaOptional.isPresent()) {
            ventaService.deleteById(id);
            return new ResponseEntity<>("Venta eliminada exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Venta no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
