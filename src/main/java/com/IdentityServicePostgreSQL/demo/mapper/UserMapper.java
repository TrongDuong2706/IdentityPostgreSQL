package com.IdentityServicePostgreSQL.demo.mapper;

import com.IdentityServicePostgreSQL.demo.dto.request.CreateUserRequest;
import com.IdentityServicePostgreSQL.demo.dto.request.UpdateUserRequest;
import com.IdentityServicePostgreSQL.demo.dto.response.CreateUserResponse;
import com.IdentityServicePostgreSQL.demo.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toUser(CreateUserRequest createUserRequest);
    CreateUserResponse toCreateUserResponse(Users user);
    void updateUser(@MappingTarget Users users, UpdateUserRequest updateUserRequest);

}
