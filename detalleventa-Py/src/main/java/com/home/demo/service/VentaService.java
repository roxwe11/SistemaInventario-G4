package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.VentaEntity;
import com.home.demo.repository.VentaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public void save(VentaEntity venta) {
        ventaRepository.save(venta);
    }

    public List<VentaEntity> findAll() {
        return ventaRepository.findAll();
    }

    public Optional<VentaEntity> findById(int id) {
        return ventaRepository.findById(id);
    }

    public void deleteById(int id) {
        ventaRepository.deleteById(id);
    }
}

