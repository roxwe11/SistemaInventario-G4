package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.ComprobantePagoEntity;
import com.home.demo.repository.ComprobantePagoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComprobantePagoService {

    @Autowired
    private ComprobantePagoRepository comprobantePagoRepository;

    public void save(ComprobantePagoEntity comprobantePago) {
        comprobantePagoRepository.save(comprobantePago);
    }

    public List<ComprobantePagoEntity> findAll() {
        return comprobantePagoRepository.findAll();
    }

    public Optional<ComprobantePagoEntity> findById(int id) {
        return comprobantePagoRepository.findById(id);
    }

    public void deleteById(int id) {
        comprobantePagoRepository.deleteById(id);
    }
}
