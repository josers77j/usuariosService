package com.apiService.crud.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiService.crud.models.UserModel;
import com.apiService.crud.services.UserService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user) {       
        return this.userService.saveUser(user);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id ) {
        return this.userService.getById(id);
    }
    
    @PatchMapping
    public UserModel updateUserById(@RequestBody UserModel request, Long id) {
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}") 
    public String deleteById(@PathVariable("id") Long id){               
        boolean ok = this.userService.deleteUser(id);
        if (ok) return "User with id" + id + " Deleted!"; 

        return  "Error deleting the user with id: "+id+". It may not have existed." ;  
    }


    
}
