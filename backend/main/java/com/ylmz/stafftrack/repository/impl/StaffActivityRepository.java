package com.ylmz.stafftrack.repository.impl;

import com.ylmz.stafftrack.dto.StaffActivityDto;
import com.ylmz.stafftrack.entity.StaffActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffActivityRepository extends JpaRepository<StaffActivity,Integer> {

    @Query(value = "select sa.staffId as staffId, s.name as name, s.lastName as lastName, sa.roomId as roomId, sa.entryTime as entryTime, sa.exitTime as exitTime from Staff s join StaffActivity sa on s.id = sa.staffId")
    List<StaffActivityDto> getStaffActivitiesByNameLastName();

    @Query(value = "select sa.staffId as staffId, s.name as name, s.lastName as lastName, sa.roomId as roomId, sa.entryTime as entryTime, sa.exitTime as exitTime from Staff s join StaffActivity sa on s.id = sa.staffId where s.id = ?1")
    List<StaffActivityDto> getStaffActivitiesByNameLastNameAndId(int id);

    @Query(nativeQuery = true,value = "SELECT SUM(TIMESTAMPDIFF(SECOND, entry_time, exit_time)) AS RESULT FROM staff_activities where staff_id = ?1")
    Integer getTotalTimeById(int id);
}
