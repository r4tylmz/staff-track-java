package com.ylmz.stafftrack.repository.impl;

import com.ylmz.stafftrack.entity.User;
import com.ylmz.stafftrack.repository.BaseRepository;

public interface IUserRepository extends BaseRepository<User> {
    User getUserByEmail(String email);
    User checkUserEmailAndPass(String email, String password);
}
