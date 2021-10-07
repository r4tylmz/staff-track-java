package com.ylmz.stafftrack.service.impl;

import com.ylmz.stafftrack.dto.StaffActivityDto;
import com.ylmz.stafftrack.entity.Constant;
import com.ylmz.stafftrack.entity.StaffActivity;
import com.ylmz.stafftrack.repository.impl.ConstantRepository;
import com.ylmz.stafftrack.repository.impl.IStaffActivityRepository;
import com.ylmz.stafftrack.service.IStaffActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaffActivityServiceImpl implements IStaffActivityService {

    private final IStaffActivityRepository repository;
    private final ConstantRepository constantRepository;

    @Autowired
    public StaffActivityServiceImpl(@Lazy IStaffActivityRepository repository, ConstantRepository constantRepository) {
        this.repository = repository;
        this.constantRepository = constantRepository;
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

    @Override
    public List<StaffActivityDto> getActivitiesByNameLastName() {
        return repository.getActivitiesByNameLastName();
    }

    @Override
    public List<StaffActivityDto> getActivitiesByNameLastNameAndId(int id) {
        return repository.getActivitiesByNameLastNameAndId(id);
    }

    public List<StaffActivityDto> getSecurityResults(int id){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        Constant constant = constantRepository.getById(1);
        List<StaffActivityDto> list = repository.getActivitiesByNameLastNameAndId(id);
        LocalTime start = LocalTime.from(dtf.parse(constant.getWorkingHourStart()));
        LocalTime end = LocalTime.from(dtf.parse(constant.getWorkingHourEnd()));

        for(int i=0; i<list.size();i++){
            if(list.get(i).getExitTime().toLocalTime().isBefore(end) && list.get(i).getEntryTime().toLocalTime().isAfter(start)){
                list.remove(i);
            }
        }
        return list;
    }

    @Override
    public Integer getTotalTimeById(int id) {
        return repository.getTotalTimeById(id);
    }
}
