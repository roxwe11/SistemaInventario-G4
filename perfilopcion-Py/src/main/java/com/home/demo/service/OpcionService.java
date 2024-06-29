package com.home.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.demo.entity.OpcionEntity;
import com.home.demo.repository.OpcionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OpcionService {
	@Autowired
	OpcionRepository opcionRepository;
	
	public List<OpcionEntity> findAll(){
		return opcionRepository.findAll();
	}
	public void guardar(OpcionEntity opcionEntity) {
		opcionRepository.save(opcionEntity);
	}
	public Optional<OpcionEntity> ObtenerPorId(int id){
		return opcionRepository.findById(id);
	}
	public void eliminar(int id) {
		opcionRepository.deleteById(id);
	}
	public boolean existePorId(int id) {
		return opcionRepository.existsById(id);
	}
	public void actualizar(int id,OpcionEntity opcionEntity) {
		Optional<OpcionEntity> optionalOpcion = opcionRepository.findById(id);
		if (optionalOpcion.isPresent()) {
			OpcionEntity opcion =optionalOpcion.get();
			opcion.setNombreOpcion(opcionEntity.getNombreOpcion());
			opcion.setDescripcion(opcionEntity.getDescripcion());
			opcionRepository.save(opcion);
		}
	}
}
