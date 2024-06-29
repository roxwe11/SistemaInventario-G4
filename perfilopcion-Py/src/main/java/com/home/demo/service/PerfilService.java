package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.PerfilEntity;
import com.home.demo.repository.PerfilRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public void save(PerfilEntity perfil) {
        perfilRepository.save(perfil);
    }

    public List<PerfilEntity> findAll() {
        return perfilRepository.findAll();
    }

    public Optional<PerfilEntity> findById(int id) {
        return perfilRepository.findById(id);
    }

    public void deleteById(int id) {
        perfilRepository.deleteById(id);
    }
}
