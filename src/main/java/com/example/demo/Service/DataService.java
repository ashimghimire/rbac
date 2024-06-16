package com.example.demo.Service;

import com.example.demo.entity.Datatable;
import com.example.demo.repository.DataRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    @Autowired
    private  DataRepository dataRepository;

    public Page<Datatable> findAll(int page,int size){
        Pageable paging= PageRequest.of(page,size);
        Page<Datatable> pagedTable;
        pagedTable= this.dataRepository.findAll(paging);
        return pagedTable;
    }

    public Datatable add(Datatable datatable){
        return this.dataRepository.save(datatable);
    }

    public Page<Datatable> sort(String type, int page,int size){
        Sort sort=Sort.by(type);
        Pageable paging= PageRequest.of(page,size,Sort.by(type).ascending());
        return this.dataRepository.findAll(paging);
    }

}
