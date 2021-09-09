package com.ylmz.stafftrack.service.impl;

import com.ylmz.stafftrack.entity.Staff;
import com.ylmz.stafftrack.repository.BaseRepository;
import com.ylmz.stafftrack.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements BaseService<Staff> {

    private final BaseRepository<Staff> repository;

    @Autowired
    public StaffServiceImpl(@Lazy BaseRepository<Staff> repository) {
        this.repository = repository;
    }

    @Override
    public Staff getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Staff> getAll() {
        return repository.getAll();
    }

    @Override
    public Staff update(Staff entity) {
        return repository.update(entity);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Staff save(Staff entity) {
        return repository.save(entity);
    }

    @Override
    public List<Staff> saveAll(List<Staff> entities) {
        return repository.saveAll(entities);
    }
}
