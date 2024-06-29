package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.FormaPagoEntity;
import com.home.demo.repository.FormaPagoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagoService {

    @Autowired
    private FormaPagoRepository formaPagoRepository;

    public void save(FormaPagoEntity formaPago) {
        formaPagoRepository.save(formaPago);
    }

    public List<FormaPagoEntity> findAll() {
        return formaPagoRepository.findAll();
    }

    public Optional<FormaPagoEntity> findById(int id) {
        return formaPagoRepository.findById(id);
    }

    public void deleteById(int id) {
        formaPagoRepository.deleteById(id);
    }
}
