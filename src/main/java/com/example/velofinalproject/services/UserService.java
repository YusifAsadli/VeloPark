package com.example.velofinalproject.services;

import com.example.velofinalproject.dtos.user.UserInfoDto;
import com.example.velofinalproject.dtos.user.UserRegisterDto;
import com.example.velofinalproject.models.UserEntity;

public interface UserService {

    boolean register (UserRegisterDto userRegisterDto);
    UserInfoDto getUserInfo (String userEmail);
}
