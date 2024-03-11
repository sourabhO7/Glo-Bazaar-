package com.app.globazaar.service;

import com.app.globazaar.dto.UserDto;

public interface UserService {
    UserDto addUser(UserDto userDTO);

    UserDto getUserById(Long userId);
    void deleteUser(Long userId);
}
