package com.example.basiccrud.controller;

import com.example.basiccrud.dto.UserDto;
import com.example.basiccrud.entity.User;
import com.example.basiccrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }


    @PostMapping("/create")
    public ResponseEntity<UserDto> creatUer(@RequestBody UserDto user){ // json nesnemizi User classlarımızla eşleştiriyoruz @RequestBody anatasyonu ile
        UserDto resultUser = userService.createUser(user); // dönen userı bir değişkende tutuyoruz
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getUser(){
       List<UserDto> users = userService.getUser();
        return ResponseEntity.ok(users); // getUser ile dönen değerleri listede tutuyoruz ve liste olarak response body de dönüyor
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){
        UserDto user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id ,@RequestBody UserDto user){
        UserDto resultUser = userService.updateUser(id,user);
        return ResponseEntity.ok(resultUser);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
      Boolean status = userService.deleteUser(id);
      return ResponseEntity.ok(status);
    }
}
