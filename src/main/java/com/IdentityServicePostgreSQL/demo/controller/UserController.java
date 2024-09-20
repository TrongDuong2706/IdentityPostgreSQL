package com.IdentityServicePostgreSQL.demo.controller;

import com.IdentityServicePostgreSQL.demo.dto.ApiResponse;
import com.IdentityServicePostgreSQL.demo.dto.request.CreateUserRequest;
import com.IdentityServicePostgreSQL.demo.dto.request.UpdateUserRequest;
import com.IdentityServicePostgreSQL.demo.dto.response.CreateUserResponse;
import com.IdentityServicePostgreSQL.demo.service.UserService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;
    @PostMapping()
    public ApiResponse<CreateUserResponse> createUser(@RequestBody CreateUserRequest request){
        return ApiResponse.<CreateUserResponse>builder()
                .result(userService.createUser(request))
                .build();
    }
    @PutMapping("/{userId}")
    public ApiResponse<CreateUserResponse> updateUser(@RequestBody UpdateUserRequest request, @PathVariable String userId){
        return ApiResponse.<CreateUserResponse>builder()
                .result(userService.updateUser(request,userId))
                .build();
    }
    @GetMapping()
    public ApiResponse<List<CreateUserResponse>> getAllUser(){
        return ApiResponse.<List<CreateUserResponse>>builder()
                .result(userService.getALlUser())
                .build();
    }
    @GetMapping("/{userId}")
    public ApiResponse<CreateUserResponse> getOneUser(@PathVariable String userId){
        return ApiResponse.<CreateUserResponse>builder()
                .result(userService.getOneUser(userId))
                .build();
    }
    @DeleteMapping("/{userId}")
    public ApiResponse<String> deleteUser(@PathVariable String userId){
        return ApiResponse.<String>builder()
                .result("Delete successful")
                .build();
    }

}
