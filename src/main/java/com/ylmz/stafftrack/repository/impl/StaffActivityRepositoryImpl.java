package com.ylmz.stafftrack.repository.impl;

import com.ylmz.stafftrack.entity.StaffActivity;
import com.ylmz.stafftrack.repository.BaseRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffActivityRepositoryImpl implements BaseRepository<StaffActivity> {

    private final StaffActivityRepository repository;

    public StaffActivityRepositoryImpl(@Lazy StaffActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    public StaffActivity getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<StaffActivity> getAll() {
        return repository.findAll();
    }

    @Override
    public StaffActivity update(StaffActivity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public StaffActivity save(StaffActivity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public List<StaffActivity> saveAll(List<StaffActivity> entities) {
        return repository.saveAllAndFlush(entities);
    }
}
