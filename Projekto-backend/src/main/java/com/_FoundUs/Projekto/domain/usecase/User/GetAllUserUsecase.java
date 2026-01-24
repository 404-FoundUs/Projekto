package com._FoundUs.Projekto.domain.usecase.User;

import com._FoundUs.Projekto.domain.model.UserModel;
import com._FoundUs.Projekto.domain.repository.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllUserUsecase {
    private final UserStore userStore;

    public List<UserModel> findAllUsers() {
        return userStore.findAllUsers();
    }
}
