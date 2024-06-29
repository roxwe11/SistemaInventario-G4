package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.ProductoEntity;
import com.home.demo.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public void save(ProductoEntity producto) {
        productoRepository.save(producto);
    }

    public List<ProductoEntity> findAll() {
        return productoRepository.findAll();
    }

    public Optional<ProductoEntity> findById(int id) {
        return productoRepository.findById(id);
    }

    public void deleteById(int id) {
        productoRepository.deleteById(id);
    }
}
