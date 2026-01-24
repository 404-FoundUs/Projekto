package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.data.entity.Workspace;
import com._FoundUs.Projekto.data.mapper.UserMapper;
import com._FoundUs.Projekto.data.repository.UserRepository;
import com._FoundUs.Projekto.domain.enums.Visibility;
import com._FoundUs.Projekto.domain.model.UserModel;
import com._FoundUs.Projekto.domain.repository.UserStore;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserStore {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserModel saveUser(UserModel userModel) {
        User userEntity = userMapper.toUser(userModel);

        if (userEntity.getWorkspaces() == null || userEntity.getWorkspaces().isEmpty()) {
            Workspace defaultWorkspace = Workspace.builder()
                    .name(userEntity.getFirstName() + "'s Workspace")
                    .description("Default workspace")
                    .visibility(Visibility.PRIVATE)
                    .owner(userEntity)
                    .build();

            userEntity.getWorkspaces().add(defaultWorkspace);
        }

        User savedUser = userRepository.save(userEntity);
        return userMapper.toUserModel(savedUser);
    }


    @Override
    public UserModel UpdateUser(UUID id, UserModel userModel) {
        User user = userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("User not found"));//entity
        user.setUsername(userModel.getUsername());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setIsActive(userModel.getIsActive());
        User savedUser = userRepository.save(user);
        return userMapper.toUserModel(savedUser);
    }

    @Override
    public Optional<UserModel> findByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .map(userMapper::toUserModel);
    }


}
