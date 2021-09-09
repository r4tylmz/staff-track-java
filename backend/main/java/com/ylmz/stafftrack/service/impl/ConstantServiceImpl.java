package com.ylmz.stafftrack.service.impl;

import com.ylmz.stafftrack.entity.Constant;
import com.ylmz.stafftrack.repository.BaseRepository;
import com.ylmz.stafftrack.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstantServiceImpl implements BaseService<Constant> {

    private final BaseRepository<Constant> repository;

    @Autowired
    public ConstantServiceImpl(@Lazy BaseRepository<Constant> repository) {
        this.repository = repository;
    }

    @Override
    public Constant getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Constant> getAll() {
        return repository.getAll();
    }

    @Override
    public Constant update(Constant entity) {
        return repository.update(entity);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Constant save(Constant entity) {
        return repository.save(entity);
    }

    @Override
    public List<Constant> saveAll(List<Constant> entities) {
        return repository.saveAll(entities);
    }
}
