package com.ylmz.stafftrack.service.impl;

import com.ylmz.stafftrack.entity.StaffActivity;
import com.ylmz.stafftrack.repository.BaseRepository;
import com.ylmz.stafftrack.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffActivityServiceImpl implements BaseService<StaffActivity> {

    private final BaseRepository<StaffActivity> repository;

    @Autowired
    public StaffActivityServiceImpl(@Lazy BaseRepository<StaffActivity> repository) {
        this.repository = repository;
    }

    @Override
    public StaffActivity getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<StaffActivity> getAll() {
        return repository.getAll();
    }

    @Override
    public StaffActivity update(StaffActivity entity) {
        return repository.update(entity);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public StaffActivity save(StaffActivity entity) {
        return repository.save(entity);
    }

    @Override
    public List<StaffActivity> saveAll(List<StaffActivity> entities) {
        return repository.saveAll(entities);
    }
}
