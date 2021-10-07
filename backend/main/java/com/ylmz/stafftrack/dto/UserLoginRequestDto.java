package com.ylmz.stafftrack.dto;

import com.ylmz.stafftrack.utils.Crypto;
import lombok.Data;

@Data
public class UserLoginRequestDto
{
    private String username;
    private String password;
    private String token;

    public String getPassword() {
        return Crypto.getSha1(password);
    }
}
