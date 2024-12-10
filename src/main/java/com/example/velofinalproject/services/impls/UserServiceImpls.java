package com.example.velofinalproject.services.impls;

import com.example.velofinalproject.dtos.user.UserInfoDto;
import com.example.velofinalproject.dtos.user.UserRegisterDto;
import com.example.velofinalproject.models.UserEntity;
import com.example.velofinalproject.repositories.UserRepository;
import com.example.velofinalproject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UserServiceImpls implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpls(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public boolean register(UserRegisterDto userRegisterDto) {
        try {
            UserEntity findUser=userRepository.findByEmail(userRegisterDto.getEmail());
            if(findUser!=null){
                return false;
            }

            UserEntity user=modelMapper.map(userRegisterDto, UserEntity.class);
            String password=bCryptPasswordEncoder.encode(userRegisterDto.getPassword());
            user.setPassword(password);
            UUID uuid=UUID.randomUUID();
            user.setEmailToken(uuid.toString());
            user.setEmailConfirmed(false);
            userRepository.save(user);

            return true;
        } catch (Exception e) {
            return false;
        }
    }



    @Override
    public UserInfoDto getUserInfo(String userEmail) {
        UserEntity user=userRepository.findByEmail(userEmail);
        UserInfoDto result=modelMapper.map(user, UserInfoDto.class);
        return result;
    }







}
