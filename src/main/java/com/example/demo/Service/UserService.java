package com.example.demo.Service;

import com.example.demo.dto.RegisterUserDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.RoleEnum;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;
   @Autowired
    private  RoleRepository roleRepository;

    private  PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
         userRepository.findAll().forEach(users::add);
         return users;
    }
    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    public User createAdministrator(RegisterUserDto input) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ADMIN);

        if (optionalRole.isEmpty()) {
            return null;
        }

        var user = new User();
        user   .setName(input.getName());
        user     .setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        user        .setRole(optionalRole.get());

        return userRepository.save(user);
    }

}
