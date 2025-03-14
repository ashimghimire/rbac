package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.RoleEnum;
import com.example.demo.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository  extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
