package com.skyrock.interview.services;

import com.skyrock.interview.models.Users;
import com.skyrock.interview.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public Users createUser(Users users){
       return usersRepository.save(users);
    }

    public List<Users> getAllUsers(){
        return  usersRepository.findAll();
    }

    public Optional<Users> getSingleUser(Long id){
        return  usersRepository.findById(id);
    }
     public Users updateUser(Long id, Users users){
        users.setId(id);
        return this.createUser(users);
     }

     public void deleteUser(Long id){
        usersRepository.deleteById(id);
     }

     public Users findByFirstNameLastNameAndId(String firstName, String lastName, Long id){
       return usersRepository.findByFirstNameAndSurnameAndId(firstName, lastName, id);
     }



}
