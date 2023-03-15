package com.org.user.controller;

import com.org.user.entity.User;
import com.org.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/listar")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.listar();
        if (users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        User user = userService.buscar(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/registrar")
    public ResponseEntity<User> save (@RequestBody User user){
        User userNew = userService.registrar(user);
        return ResponseEntity.ok(userNew);
    }
}
