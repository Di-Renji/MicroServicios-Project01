package com.org.user.service;

import com.org.user.entity.User;
import com.org.user.feignclients.BikeFeignClient;
import com.org.user.feignclients.CarFeignClient;
import com.org.user.model.Bike;
import com.org.user.model.Car;
import com.org.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CarFeignClient carFeignClient;
    @Autowired
    BikeFeignClient bikeFeignClient;


    public List<User> listar(){
        return userRepository.findAll();
    }

    public User buscar(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User registrar(User user){
        User userNew = userRepository.save(user);
        return userNew;
    }

    // Metodos para el RestTemplate
    public List<Car> getCars(int userId){
        List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/byuser/" + userId, List.class);
        return cars;
    }

    public List<Bike> getBikes(int userId){
        List<Bike> bikes = restTemplate.getForObject("http://localhost:8003/bike/byuser/" + userId, List.class);
        return bikes;
    }

    // Feign Client

    public Car saveCar(int userId, Car car){
        car.setUserId(userId);
        Car carNew = carFeignClient.save(car);
        return carNew;
    }

    public Bike saveBike(int userId, Bike bike){
        bike.setUserId(userId);
        Bike bikeNew = bikeFeignClient.save(bike);
        return bikeNew;
    }

}
