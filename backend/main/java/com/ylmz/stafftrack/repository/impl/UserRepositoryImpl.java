package com.ylmz.stafftrack.repository.impl;

import com.ylmz.stafftrack.entity.User;
import com.ylmz.stafftrack.utils.Crypto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Api(tags = "Address Entity")
public class UserRepositoryImpl implements IUserRepository {

    private final UserRepository repository;


    @Autowired
    public UserRepositoryImpl(@Lazy UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public User save(User entity) {
        entity.setPassword(Crypto.getSha1(entity.getPassword()));
        return repository.save(entity);
    }

    @Override
    public List<User> saveAll(List<User> entities) {
        return repository.saveAllAndFlush(entities);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }

    @Override
    public User checkUserEmailAndPass(String email, String password) {
        return repository.checkUserEmailAndPass(email, password);
    }


}
