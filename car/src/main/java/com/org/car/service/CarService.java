package com.org.car.service;

import com.org.car.entity.Car;
import com.org.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> listar(){
        return carRepository.findAll();
    }

    public Car buscar(int id){
        return carRepository.findById(id).orElse(null);
    }

    public Car registrar(Car car){
        Car carNew = carRepository.save(car);
        return carNew;
    }

    public List<Car> obtenerUsuario(int userId){
        return carRepository.findByUserId(userId);
    }
}
