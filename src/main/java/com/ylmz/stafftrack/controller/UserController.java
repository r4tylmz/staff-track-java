package com.ylmz.stafftrack.controller;

import com.ylmz.stafftrack.dto.UserDto;
import com.ylmz.stafftrack.entity.User;
import com.ylmz.stafftrack.service.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
    private final BaseService<User> service;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(BaseService<User> service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(service.getAll().stream().map(user -> modelMapper
                .map(user, UserDto.class))
                .collect(Collectors.toList()));
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> save(@RequestBody User user){
        return ResponseEntity.ok(modelMapper.map(service.save(user),UserDto.class));
    }
}
