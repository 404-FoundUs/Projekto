package com._FoundUs.Projekto.domain.usecase.User;

import com._FoundUs.Projekto.domain.model.UserModel;
import com._FoundUs.Projekto.domain.repository.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveUserUsecase {
    private final UserStore userStore;

    public UserModel SaveUser(UserModel userModel) {
        return userStore.saveUser(userModel);
    }
}
