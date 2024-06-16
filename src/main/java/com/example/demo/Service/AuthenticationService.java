package com.example.demo.Service;
import com.example.demo.dto.LoginUserDto;
import com.example.demo.dto.RegisterUserDto;
import com.example.demo.entity.*;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class AuthenticationService {


        private  final UserRepository userRepository;

        private final RoleRepository roleRepository;

        private final  PasswordEncoder passwordEncoder;



    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }


    public User signup(RegisterUserDto input) {
            System.out.println(input);
            System.out.println(roleRepository.findByName(RoleEnum.USER));
            Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);
            System.out.println(optionalRole);
            if (optionalRole.isEmpty()) {
                return null;
            }

            var user = new User();
            user     .setName(input.getName());
            user    .setEmail(input.getEmail());
            user      .setPassword(passwordEncoder.encode(input.getPassword()));
            user        .setRole(optionalRole.get());

            return userRepository.save(user);
        }


        public User authenticate(LoginUserDto input) {
            return userRepository.findByEmail(input.getEmail()).orElseThrow();
        }

        public List<User> allUsers() {
            List<User> users = new ArrayList<>();

            userRepository.findAll().forEach(users::add);

            return users;
        }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());

        return authProvider;
    }

    UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    }

