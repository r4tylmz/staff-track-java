package com.ylmz.stafftrack.auth;

import com.ylmz.stafftrack.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private IUserService service;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.ylmz.stafftrack.entity.User user = service.getUserByEmail(username);
        if(user != null){
            return new User(username, bCryptPasswordEncoder.encode(user.getPassword()), new ArrayList<>());
        }
        throw new UsernameNotFoundException(username);
    }
}
