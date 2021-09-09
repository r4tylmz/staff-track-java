package com.ylmz.stafftrack.controller;

import com.ylmz.stafftrack.auth.TokenManager;
import com.ylmz.stafftrack.dto.UserLoginRequestDto;
import com.ylmz.stafftrack.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserService service;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequestDto userLoginRequestDto){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequestDto.getUsername(), userLoginRequestDto.getPassword()));
        }catch (Exception e){
            throw e;
        }
        finally {
            return ResponseEntity.ok(tokenManager.generateToken(userLoginRequestDto.getUsername()));
        }
    }
}
