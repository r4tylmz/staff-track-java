package com.ylmz.stafftrack.controller;

import com.ylmz.stafftrack.entity.Constant;
import com.ylmz.stafftrack.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConstantController {

    private final BaseService<Constant> service;

    @Autowired
    public ConstantController(BaseService<Constant> service) {
        this.service = service;
    }

    @GetMapping("/constants")
    public ResponseEntity<List<Constant>> getConstants(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/constants")
    public ResponseEntity<Constant> save(@RequestBody Constant constant){
        return ResponseEntity.ok(service.save(constant));
    }
    @PutMapping("/constants")
    public ResponseEntity<Constant> update(@RequestBody Constant constant){
        return ResponseEntity.ok(service.save(constant));
    }
}
