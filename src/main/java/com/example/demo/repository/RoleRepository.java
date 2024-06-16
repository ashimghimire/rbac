package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.RoleEnum;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}
