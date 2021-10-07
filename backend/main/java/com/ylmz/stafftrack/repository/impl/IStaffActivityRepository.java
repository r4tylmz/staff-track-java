package com.ylmz.stafftrack.repository.impl;

import com.ylmz.stafftrack.dto.StaffActivityDto;
import com.ylmz.stafftrack.entity.StaffActivity;
import com.ylmz.stafftrack.repository.BaseRepository;

import java.util.List;

public interface IStaffActivityRepository extends BaseRepository<StaffActivity> {
    List<StaffActivityDto> getActivitiesByNameLastName();
    List<StaffActivityDto> getActivitiesByNameLastNameAndId(int id);
    Integer getTotalTimeById(int id);
}
