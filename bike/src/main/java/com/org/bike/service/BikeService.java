package com.org.bike.service;

import com.org.bike.entity.Bike;
import com.org.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    BikeRepository bikeRepository;

    public List<Bike> listar(){
        return bikeRepository.findAll();
    }

    public Bike buscar(int id){
        return bikeRepository.findById(id).orElse(null);
    }

    public Bike registrar(Bike bike){
        Bike bikeNew = bikeRepository.save(bike);
        return bikeNew;
    }

    public List<Bike> obtenerUsuario(int userId){
        return bikeRepository.findByUserId(userId);
    }


}
