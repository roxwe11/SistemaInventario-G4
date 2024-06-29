package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.UsuarioEntity;
import com.home.demo.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void save(UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
    }

    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> findById(int id) {
        return usuarioRepository.findById(id);
    }

    public void deleteById(int id) {
        usuarioRepository.deleteById(id);
    }
}
