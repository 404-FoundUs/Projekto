package com._FoundUs.Projekto.domain.usecase.User;

import com._FoundUs.Projekto.domain.model.UserModel;
import com._FoundUs.Projekto.domain.repository.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindUserUsecase {
    private final UserStore userStore;

    public UserModel findById(UUID id) {
        return userStore.findById(id);
    }
}
