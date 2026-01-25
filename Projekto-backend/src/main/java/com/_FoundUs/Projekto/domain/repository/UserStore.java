package com._FoundUs.Projekto.domain.repository;

import com._FoundUs.Projekto.domain.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserStore {
    UserModel saveUser(UserModel userModel);
    UserModel UpdateUser(UUID id,UserModel userModel);
    Optional<UserModel> findByEmail(String email);

}
