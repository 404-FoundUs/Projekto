package com._FoundUs.Projekto.domain.usecase.User;

import com._FoundUs.Projekto.domain.repository.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeleteUserUsecase {

    private final UserStore userStore;

    public void deleteUser(UUID id) {
        userStore.deleteUser(id);
    }
}
