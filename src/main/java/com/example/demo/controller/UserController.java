package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.entity.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {



        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping("/me")
        @PreAuthorize("isAuthenticated()")
        public ResponseEntity<User> authenticatedUser() {
           return null;
        }

        @GetMapping
        @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
        public ResponseEntity<List<User>> allUsers() {
            return new ResponseEntity<>(userService.allUsers(), HttpStatus.OK);
        }
    }

