package com.home.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.home.demo.dto.ProductoDto;
import com.home.demo.entity.ProductoEntity;
import com.home.demo.service.ProductoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Crear un nuevo producto
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductoDto productoDto) {
        ProductoEntity producto = new ProductoEntity(
                productoDto.getNombreProducto(),
                productoDto.getPrecioCompra(),
                productoDto.getPrecioVenta(),
                productoDto.getStock(),
                productoDto.getFecha_vencimiento()
        );
        productoService.save(producto);
        return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
    }

    // Obtener todos los productos
    @GetMapping("/all")
    public ResponseEntity<List<ProductoDto>> getAllProductos() {
        List<ProductoEntity> productos = productoService.findAll();
        List<ProductoDto> productosDto = productos.stream()
            .map(producto -> new ProductoDto(
                producto.getNombreProducto(),
                producto.getPrecioCompra(),
                producto.getPrecioVenta(),
                producto.getStock(),
                producto.getFecha_vencimiento()))
            .collect(Collectors.toList());
        return new ResponseEntity<>(productosDto, HttpStatus.OK);
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable int id) {
        Optional<ProductoEntity> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            ProductoEntity producto = productoOptional.get();
            ProductoDto productoDto = new ProductoDto(
                producto.getNombreProducto(),
                producto.getPrecioCompra(),
                producto.getPrecioVenta(),
                producto.getStock(),
                producto.getFecha_vencimiento()
            );
            return new ResponseEntity<>(productoDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un producto por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable int id, @RequestBody ProductoDto productoDto) {
        Optional<ProductoEntity> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            ProductoEntity producto = productoOptional.get();
            producto.setNombreProducto(productoDto.getNombreProducto());
            producto.setPrecioCompra(productoDto.getPrecioCompra());
            producto.setPrecioVenta(productoDto.getPrecioVenta());
            producto.setStock(productoDto.getStock());
            producto.setFecha_vencimiento(productoDto.getFecha_vencimiento());
            productoService.save(producto);
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un producto por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable int id) {
        Optional<ProductoEntity> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            productoService.deleteById(id);
            return new ResponseEntity<>("Producto eliminado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}