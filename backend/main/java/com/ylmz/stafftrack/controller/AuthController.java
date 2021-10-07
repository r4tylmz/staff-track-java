package com.ylmz.stafftrack.controller;

import com.ylmz.stafftrack.auth.TokenManager;
import com.ylmz.stafftrack.dto.UserDto;
import com.ylmz.stafftrack.dto.UserLoginRequestDto;
import com.ylmz.stafftrack.dto.UserLoginResponseDto;
import com.ylmz.stafftrack.entity.User;
import com.ylmz.stafftrack.service.IUserService;
import com.ylmz.stafftrack.utils.Crypto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private IUserService service;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        User user = service.checkUserEmailAndPass(userLoginRequestDto.getUsername(), userLoginRequestDto.getPassword());
        if (user != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            String token = tokenManager.generateToken(user.getEmail());
            UserLoginResponseDto response = modelMapper.map(user, UserLoginResponseDto.class);
            response.setToken(token);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}
