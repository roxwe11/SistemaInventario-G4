package com.home.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.demo.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{

}
