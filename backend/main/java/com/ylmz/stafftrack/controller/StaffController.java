package com.ylmz.stafftrack.controller;

import com.ylmz.stafftrack.entity.Constant;
import com.ylmz.stafftrack.entity.Staff;
import com.ylmz.stafftrack.service.BaseService;
import com.ylmz.stafftrack.service.IStaffActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StaffController {
    private final BaseService<Staff> service;
    private final BaseService<Constant> constantService;
    private final IStaffActivityService staffActivityService;


    @Autowired
    public StaffController(BaseService<Staff> service, BaseService<Constant> constantService, IStaffActivityService staffActivityService) {
        this.service = service;
        this.constantService = constantService;
        this.staffActivityService = staffActivityService;
    }
    @GetMapping("/staffs")
    public ResponseEntity<List<Staff>> getAllStaffs(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/staffs/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") int id){
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/staffs")
    public ResponseEntity<Staff> save(@RequestBody Staff staff){
        return ResponseEntity.ok(service.save(staff));
    }
    @PutMapping("/staffs")
    public ResponseEntity<Staff> update(@RequestBody Staff staff){
        return ResponseEntity.ok(service.update(staff));
    }
    @DeleteMapping("/staffs/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/staffs/wage/{id}")
    public ResponseEntity<Integer> getWage(@PathVariable("id") int id){
        Constant constant = constantService.getById(1);
        int salary = constant.getHourlyWage() * staffActivityService.getTotalTimeById(id);
        return ResponseEntity.ok(salary);
    }


}
