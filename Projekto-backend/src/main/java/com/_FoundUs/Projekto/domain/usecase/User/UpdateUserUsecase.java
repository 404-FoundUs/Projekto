package com._FoundUs.Projekto.domain.usecase.User;

import com._FoundUs.Projekto.domain.model.UserModel;
import com._FoundUs.Projekto.domain.repository.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
// this use case belongs to profile domain.
//fix this
public class UpdateUserUsecase {
    private final UserStore userStore;

    public UserModel UpdateUser(UUID id,UserModel userModel) {
        return userStore.UpdateUser(id, userModel);
    }
}
