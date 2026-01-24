package com._FoundUs.Projekto.presentation.controller;

import com._FoundUs.Projekto.domain.model.UserModel;
import com._FoundUs.Projekto.domain.usecase.User.*;
import com._FoundUs.Projekto.presentation.dto.RequestUserDto;
import com._FoundUs.Projekto.presentation.dto.ResponseUserDto;
import com._FoundUs.Projekto.presentation.dto.SigninRequestDto;
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
    private final SigninUserUsecase signinUserUsecase;

    private final UserApiMapper userApiMapper;

    @PostMapping("/signup")
    public ResponseEntity<ResponseUserDto> saveUser(@RequestBody RequestUserDto requestUserDto) {
        UserModel userModel = userApiMapper.toUserModel(requestUserDto);
        UserModel saveUserModel = saveUserUsecase.SaveUser(userModel);
        return new ResponseEntity<>(userApiMapper.toResponseUserdto(saveUserModel), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseUserDto> signin(@RequestBody SigninRequestDto request) {
        UserModel userModel = signinUserUsecase.signin(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(userApiMapper.toResponseUserdto(userModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDto> updateUser(@PathVariable UUID id, @RequestBody RequestUserDto requestUserDto) {
        UserModel userModel = userApiMapper.toUserModel(requestUserDto);
        UserModel updateUserModel = updateUserUsecase.UpdateUser(id, userModel);
        return new ResponseEntity<>(userApiMapper.toResponseUserdto(updateUserModel), HttpStatus.OK);
    }

}
