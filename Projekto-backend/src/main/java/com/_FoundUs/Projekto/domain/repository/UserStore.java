package com._FoundUs.Projekto.domain.repository;

import com._FoundUs.Projekto.domain.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserStore {
    UserModel saveUser(UserModel userModel);
    UserModel findById(UUID id);
    UserModel UpdateUser(UUID id,UserModel userModel);
    void deleteUser(UUID id);
    List<UserModel> findAllUsers();
}
