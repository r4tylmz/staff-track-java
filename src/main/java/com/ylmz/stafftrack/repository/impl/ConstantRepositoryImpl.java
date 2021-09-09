package com.ylmz.stafftrack.repository.impl;

import com.ylmz.stafftrack.entity.Constant;
import com.ylmz.stafftrack.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ConstantRepositoryImpl implements BaseRepository<Constant> {

    private final ConstantRepository repository;

    @Autowired
    public ConstantRepositoryImpl(@Lazy ConstantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Constant getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Constant> getAll() {
        return repository.findAll();
    }

    @Override
    public Constant update(Constant entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Constant save(Constant entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public List<Constant> saveAll(List<Constant> entities) {
        return repository.saveAllAndFlush(entities);
    }
}
