package com.home.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.demo.entity.TipoEntity;

public interface TipoRepository extends JpaRepository<TipoEntity, Integer>{

}
