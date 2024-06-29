package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.TipoEntity;
import com.home.demo.repository.TipoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public void save(TipoEntity tipo) {
        tipoRepository.save(tipo);
    }

    public List<TipoEntity> findAll() {
        return tipoRepository.findAll();
    }

    public Optional<TipoEntity> findById(int id) {
        return tipoRepository.findById(id);
    }

    public void deleteById(int id) {
        tipoRepository.deleteById(id);
    }
}
