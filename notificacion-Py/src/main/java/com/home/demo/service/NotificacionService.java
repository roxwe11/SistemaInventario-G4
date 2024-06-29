package com.home.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.demo.entity.NotificacionEntity;
import com.home.demo.repository.NotificacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public void save(NotificacionEntity notificacion) {
        notificacionRepository.save(notificacion);
    }

    public List<NotificacionEntity> findAll() {
        return notificacionRepository.findAll();
    }

    public Optional<NotificacionEntity> findById(int id) {
        return notificacionRepository.findById(id);
    }

    public void deleteById(int id) {
        notificacionRepository.deleteById(id);
    }
}
