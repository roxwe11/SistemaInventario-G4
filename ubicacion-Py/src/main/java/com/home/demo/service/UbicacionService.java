package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.UbicacionEntity;
import com.home.demo.repository.UbicacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public void save(UbicacionEntity ubicacion) {
        ubicacionRepository.save(ubicacion);
    }

    public List<UbicacionEntity> findAll() {
        return ubicacionRepository.findAll();
    }

    public Optional<UbicacionEntity> findById(int id) {
        return ubicacionRepository.findById(id);
    }

    public void deleteById(int id) {
        ubicacionRepository.deleteById(id);
    }
}

