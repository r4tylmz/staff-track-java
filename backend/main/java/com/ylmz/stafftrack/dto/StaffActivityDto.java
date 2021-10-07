package com.ylmz.stafftrack.dto;
import java.time.LocalDateTime;

public interface StaffActivityDto {
    Integer getStaffId();
    Integer getRoomId();
    String getName();
    String getLastName();
    LocalDateTime getExitTime();
    LocalDateTime getEntryTime();
}
