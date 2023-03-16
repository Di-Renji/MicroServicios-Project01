package com.org.car.controller;

import com.org.car.entity.Car;
import com.org.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/listar")
    public ResponseEntity<List<Car>> getAll(){
        List<Car> cars = carService.listar();
        if (cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int id){
        Car car = carService.buscar(id);
        if (car == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Car> save (@RequestBody Car car){
        Car carNew = carService.registrar(car);
        return ResponseEntity.ok(carNew);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") int userId){
        List<Car> cars = carService.obtenerUsuario(userId);
        if (cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

}
