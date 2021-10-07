package com.ylmz.stafftrack.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginResponseDto extends UserDto{
    private String token;
}
