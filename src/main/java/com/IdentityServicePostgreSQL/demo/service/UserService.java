package com.IdentityServicePostgreSQL.demo.service;

import com.IdentityServicePostgreSQL.demo.dto.request.CreateUserRequest;
import com.IdentityServicePostgreSQL.demo.dto.request.UpdateUserRequest;
import com.IdentityServicePostgreSQL.demo.dto.response.CreateUserResponse;
import com.IdentityServicePostgreSQL.demo.entity.Users;
import com.IdentityServicePostgreSQL.demo.mapper.UserMapper;
import com.IdentityServicePostgreSQL.demo.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    public CreateUserResponse createUser(CreateUserRequest request){
        Users user = userMapper.toUser(request);
        userRepository.save(user);
        return userMapper.toCreateUserResponse(user);
    }

    public CreateUserResponse updateUser(UpdateUserRequest request, String userId){
        Users users = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User exsisted"));
        userMapper.updateUser(users, request);
        return userMapper.toCreateUserResponse(users);
    }
    public List<CreateUserResponse> getALlUser(){
        userRepository.findAll();
        return userRepository.findAll().stream().map(userMapper::toCreateUserResponse).toList();
    }
    public CreateUserResponse getOneUser(String userId){
        var user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User no exsist"));
        return userMapper.toCreateUserResponse(user);
    }
    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

}
