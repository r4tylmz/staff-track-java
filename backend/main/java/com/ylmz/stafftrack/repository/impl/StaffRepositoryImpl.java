package com.ylmz.stafftrack.repository.impl;

import com.ylmz.stafftrack.entity.Staff;
import com.ylmz.stafftrack.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffRepositoryImpl implements BaseRepository<Staff> {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffRepositoryImpl(@Lazy StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff getById(int id) {
        return staffRepository.findById(id).get();
    }

    @Override
    public List<Staff> getAll() {
        return staffRepository.findAll();
    }

    @Override
    public Staff update(Staff entity) {
        return staffRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Staff save(Staff entity) {
        return staffRepository.saveAndFlush(entity);
    }

    @Override
    public List<Staff> saveAll(List<Staff> entities) {
        return staffRepository.saveAllAndFlush(entities);
    }
}
