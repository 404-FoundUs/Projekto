package com._FoundUs.Projekto.data.adapter;

import com._FoundUs.Projekto.data.entity.User;
import com._FoundUs.Projekto.data.mapper.UserMapper;
import com._FoundUs.Projekto.data.repository.UserRepository;
import com._FoundUs.Projekto.domain.model.UserModel;
import com._FoundUs.Projekto.domain.repository.UserStore;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserStore {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserModel saveUser(UserModel userModel) {
        User dto = userMapper.toUser(userModel);//entity
        User savedUser = userRepository.save(dto);
        return userMapper.toUserModel(savedUser);//model
    }

    @Override
    public UserModel findById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("User not found"));
        return userMapper.toUserModel(user);//model
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
        return userMapper.toUserModel(savedUser);//model
    }

    @Override
    public void deleteUser(UUID id) {
        User user = userRepository.findById(id).orElseThrow(()->new EntityNotFoundException("User not found"));//entity
        userRepository.delete(user);
    }

    @Override
    public List<UserModel> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserModel> list = users.stream().map(userMapper::toUserModel).toList();
        return list;
    }
}
