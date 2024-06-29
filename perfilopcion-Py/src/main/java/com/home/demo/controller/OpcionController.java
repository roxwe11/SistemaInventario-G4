package com.home.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.demo.entity.OpcionEntity;
import com.home.demo.service.OpcionService;
@RestController
@RequestMapping("/apiopcion")
public class OpcionController {
	@Autowired
	OpcionService opcionService;
	
	@GetMapping("/lista")
    public ResponseEntity<List<OpcionEntity>> getAllOpcion() {
        List<OpcionEntity> list = opcionService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
	 @GetMapping("/detalle/{id}")
	    public ResponseEntity<OpcionEntity> obtenerOpcionPorId(@PathVariable("id") int id) {
	        Optional<OpcionEntity> opcionOptional = opcionService.ObtenerPorId(id);
	        return opcionOptional.map(opcion -> new ResponseEntity<>(opcion, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	 @PostMapping("/crear")
	    public ResponseEntity<String> crearOpcion(@RequestBody OpcionEntity opcionEntity) {
		    opcionService.guardar(opcionEntity);
		    return new ResponseEntity<>("Opcion creada correctamente", HttpStatus.CREATED);
	 }
	 @PutMapping("/update/{id}")
	    public ResponseEntity<String> guardarOpcion(@PathVariable int id, @RequestBody OpcionEntity opcionEntity) {
	        try {
	            if (!opcionService.existePorId(id)) {
	                return new ResponseEntity<>("No existe la opcion", HttpStatus.NOT_FOUND);
	            }
	            opcionService.guardar(opcionEntity);
	            return new ResponseEntity<>("Opcion actualizada", HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 @DeleteMapping("/eliminar/{id}")
	    public ResponseEntity<String> eliminarOpcion(@PathVariable("id") int id) {
	        if (opcionService.existePorId(id)) {
	            opcionService.eliminar(id);
	            return new ResponseEntity<>("Opcion eliminada correctamente", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("No se encontró la opcion con el ID especificado", HttpStatus.NOT_FOUND);
	        }
	    }
}
