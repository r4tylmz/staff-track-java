package com.ylmz.stafftrack.controller;

import com.ylmz.stafftrack.dto.StaffActivityDto;
import com.ylmz.stafftrack.entity.StaffActivity;
import com.ylmz.stafftrack.service.IStaffActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StaffActivityController {

    private final IStaffActivityService activityService;
    @Autowired
    public StaffActivityController(IStaffActivityService activityService) {
        this.activityService = activityService;
    }
    @GetMapping("/staffactivities")
    public ResponseEntity<List<StaffActivityDto>> getAllActivities(){
        return ResponseEntity.ok(activityService.getActivitiesByNameLastName());
    }
    @GetMapping("/staffactivities/{id}")
    public ResponseEntity<List<StaffActivityDto>> getOneActivity(@PathVariable int id){
        return ResponseEntity.ok(activityService.getActivitiesByNameLastNameAndId(id));
    }
    @PostMapping("/staffactivities")
    public ResponseEntity<StaffActivity> save(@RequestBody StaffActivity staffActivity){
        return ResponseEntity.ok(activityService.save(staffActivity));
    }
    @DeleteMapping("/staffactivities/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        activityService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/staffactivities/security/{id}")
    public ResponseEntity<List<StaffActivityDto>> getSecurityResults(@PathVariable int id){
        return ResponseEntity.ok(activityService.getSecurityResults(id));
    }
    @GetMapping("/staffactivities/totaltime/{id}")
    public ResponseEntity<Integer> getTotalTimeById(@PathVariable int id){
        return ResponseEntity.ok(activityService.getTotalTimeById(id));
    }

}
