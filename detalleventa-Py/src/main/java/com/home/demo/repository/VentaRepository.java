package com.home.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.demo.entity.VentaEntity;

public interface VentaRepository extends JpaRepository<VentaEntity, Integer> {

}
