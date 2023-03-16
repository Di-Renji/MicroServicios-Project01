package com.org.user.service;

import com.org.user.entity.User;
import com.org.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


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
}
