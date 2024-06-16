package com.example.demo.controller;

import com.example.demo.Service.DataService;
import com.example.demo.dto.SortingDto;
import com.example.demo.entity.Datatable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

@RequestMapping("/data")
@RestController
public class DatatableController {

    @Autowired
    DataService dataService;

    @GetMapping("")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Map<String, Object>> findAll( @RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10") int size) {
        try {
            Page<Datatable> datatables = dataService.findAll(page, size);
            Map<String,Object> response=buildResponse(datatables);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Map<String, Object>> add(
            @RequestBody Datatable datatable
    ) {
        try {
            Datatable datatable1 = dataService.add(datatable);
            Map<String, Object> response = new HashMap<>();
            response.put("results", datatable1);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sort")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Map<String,Object>> sort(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size,@RequestParam() String type){
        try {
            Page<Datatable> datatables = dataService.sort(type,page,size);
            Map<String,Object> response=buildResponse(datatables);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Map<String,Object> buildResponse(Page<Datatable> datatables){
        Map<String, Object> response = new HashMap<>();
        response.put("results", datatables.getContent());
        response.put("currentPage", datatables.getNumber());
        response.put("totalItems", datatables.getTotalElements());
        response.put("totalPages", datatables.getTotalPages());
        return response;
    }

}
