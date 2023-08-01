

package com.example.bookstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.User;
import com.example.bookstore.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository bRepo;
    public void saveuser(User b){
        bRepo.save(b);
    }

    public List<User> getAllUser(){
        return bRepo.findAll();
    }
    public User getUserByUsername(String username) {
        return bRepo.findByUsername(username).get();
    }
}
