package com.ylmz.stafftrack.controller;

import com.ylmz.stafftrack.entity.Staff;
import com.ylmz.stafftrack.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StaffController {
    private final BaseService<Staff> service;

    @Autowired
    public StaffController(BaseService<Staff> service) {
        this.service = service;
    }

    @GetMapping("/staffs")
    public ResponseEntity<List<Staff>> getAllStaffs(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/staffs")
    public ResponseEntity<Staff> save(@RequestBody Staff staff){
        return ResponseEntity.ok(service.save(staff));
    }
    @DeleteMapping("/staffs")
    public ResponseEntity deleteById(@RequestParam("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
