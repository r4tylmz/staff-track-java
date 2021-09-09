package com.ylmz.stafftrack.service.impl;

import com.ylmz.stafftrack.entity.User;
import com.ylmz.stafftrack.repository.BaseRepository;
import com.ylmz.stafftrack.repository.impl.IUserRepository;
import com.ylmz.stafftrack.service.BaseService;
import com.ylmz.stafftrack.service.IUserService;
import com.ylmz.stafftrack.utils.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements BaseService<User>, IUserService {

    private final IUserRepository repository;

    @Autowired
    public UserServiceImpl(@Lazy IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User update(User entity) {
        return repository.update(entity);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    @Transactional
    public User save(User entity) {
        entity.setPassword(Crypto.getMd5(entity.getPassword()));
        return repository.save(entity);
    }

    @Override
    @Transactional
    public List<User> saveAll(List<User> entities) {
        entities.forEach(item ->{ item.setPassword(Crypto.getMd5(item.getPassword()));});
        return repository.saveAll(entities);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }
}
