package com.ylmz.stafftrack.service;

import com.ylmz.stafftrack.entity.User;

public interface IUserService {
    User getUserByEmail(String email);
    User checkUserEmailAndPass(String email, String password);
}
