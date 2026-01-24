package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.model.UserModel;
import com._FoundUs.Projekto.domain.usecase.User.*;
import com._FoundUs.Projekto.presentation.dto.RequestUserDto;
import com._FoundUs.Projekto.presentation.dto.ResponseUserDto;
import com._FoundUs.Projekto.presentation.mapper.UserApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final SaveUserUsecase saveUserUsecase;
    private final UpdateUserUsecase updateUserUsecase;
    private final DeleteUserUsecase deleteUserUsecase;
    private final FindUserUsecase findUserUsecase;
    private final GetAllUserUsecase getAllUserUsecase;

    private final UserApiMapper userApiMapper;

    @PostMapping
    public ResponseEntity<ResponseUserDto> saveUser(@RequestBody RequestUserDto requestUserDto) {
        UserModel userModel = userApiMapper.toUserModel(requestUserDto);
        UserModel saveUserModel = saveUserUsecase.SaveUser(userModel);
        return new ResponseEntity<>(userApiMapper.toResponseUserdto(saveUserModel), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDto> updateUser(@PathVariable UUID id, @RequestBody RequestUserDto requestUserDto) {
        UserModel userModel = userApiMapper.toUserModel(requestUserDto);
        UserModel updateUserModel = updateUserUsecase.UpdateUser(id, userModel);
        return new ResponseEntity<>(userApiMapper.toResponseUserdto(updateUserModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseUserDto> deleteUser(@PathVariable UUID id) {
        deleteUserUsecase.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDto> getUser(@PathVariable UUID id) {
        UserModel allUsers = findUserUsecase.findById(id);
        return new ResponseEntity<>(userApiMapper.toResponseUserdto(allUsers), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseUserDto>> getAllUsers() {

        List<UserModel> allUsers = getAllUserUsecase.findAllUsers();
        List<ResponseUserDto> responseUserDtos = allUsers.stream()
                .map(userApiMapper::toResponseUserdto)
                .toList();
        return ResponseEntity.ok(responseUserDtos);
    }
}
