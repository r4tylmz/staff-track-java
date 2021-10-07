package com.ylmz.stafftrack.service;

import com.ylmz.stafftrack.dto.StaffActivityDto;
import com.ylmz.stafftrack.entity.StaffActivity;

import java.util.List;

public interface IStaffActivityService extends BaseService<StaffActivity>{
    List<StaffActivityDto> getActivitiesByNameLastName();
    List<StaffActivityDto> getActivitiesByNameLastNameAndId(int id);
    List<StaffActivityDto> getSecurityResults(int id);
    Integer getTotalTimeById(int id);

}
