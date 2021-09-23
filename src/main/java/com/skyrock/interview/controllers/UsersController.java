package com.skyrock.interview.controllers;

import com.skyrock.interview.components.ConverterComponent;
import com.skyrock.interview.dtos.UsersDto;
import com.skyrock.interview.models.Users;
import com.skyrock.interview.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;

@RestController
@RequestMapping("api/")
public class UsersController {
    @Autowired
    UserService userService;

    @Autowired
    ConverterComponent converterComponent;

    @PostMapping("user/create")
    public Users createUser(@RequestBody UsersDto usersDto){
        Date date = new Date();
        usersDto.setCreatedAt(date);
        Users users = converterComponent.convertToUsersDto(usersDto);
        return userService.createUser(users);
    }

    @GetMapping("/users")
    public Map<String,List<Users>> getAllUsers(){
        Map<String,List<Users>> usersMap = new HashMap<>();
        List<Users> users = userService.getAllUsers();
        usersMap.put("users", users);
        return usersMap;
    }

    @PutMapping("user/update/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody UsersDto usersDto){
        Users users = converterComponent.convertToUsersDto(usersDto);
        return userService.updateUser(id, users);
    }

    @DeleteMapping("user/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("user/get/{id}")
    public Optional<Users> getSingleUser(@PathVariable Long id){
      return userService.getSingleUser(id);
    }

    @GetMapping("user/search")
    public Users getByFirstLastAndId(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, @RequestParam(required = false) Long id){
        return userService.findByFirstNameLastNameAndId(firstName, lastName, id);
    }

}
