package com.example.demo.repository;

import com.example.demo.entity.Datatable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<Datatable, String> {
     Page<Datatable> findAll(Pageable pageable) ;

}
