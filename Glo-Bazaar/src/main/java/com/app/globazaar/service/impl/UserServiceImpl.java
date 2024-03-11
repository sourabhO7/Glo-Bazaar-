package com.app.globazaar.service.impl;

import com.app.globazaar.dto.UserDto;
import com.app.globazaar.entity.User;
import com.app.globazaar.exception.ResourceNotFoundException;
import com.app.globazaar.repository.UserRepository;
import com.app.globazaar.service.UserService;
import com.app.globazaar.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    // This annotation is used to inject the UserRepository bean
    @Autowired
    private UserRepository userRepository;

    // This method is used to add a user
    @Override
    public UserDto addUser(UserDto userDTO) {
        User user = Mapper.mapToUserEntity(userDTO);
        User savedUser = userRepository.save(user);
        return Mapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return Mapper.mapToUserDto(user);
    }

    // This method is used to delete a user
    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(existingUser);
    }
}