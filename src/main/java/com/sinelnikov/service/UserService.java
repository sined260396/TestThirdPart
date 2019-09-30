package com.sinelnikov.service;

import com.sinelnikov.entity.UserEntity;
import com.sinelnikov.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    public UserEntity getUserById(@NonNull final Integer id) {
        return this.userRepository.getUserById(id);
    }

    public UserEntity addUser(@NonNull final UserEntity userEntity) {
        this.userRepository.addUser(userEntity);
        return userEntity;
    }

    public UserEntity updateUser(@NonNull final UserEntity userEntity) {
        this.userRepository.updateUser(userEntity);
        return userEntity;
    }

    public void deleteUser(@NonNull final Integer id) {
        this.userRepository.deleteUser(id);
    }
}
