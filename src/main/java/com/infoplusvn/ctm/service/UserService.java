package com.infoplusvn.ctm.service;

import com.infoplusvn.ctm.dto.UserDto;

public interface UserService {

    /**
     * Register a new user
     *
     * @param userDto
     * @return
     */
    UserDto signup(UserDto userDto);

    /**
     * Search an existing user
     *
     * @param username
     * @return
     */
    UserDto findUserByUsername(String username);

    /**
     * Update profile of the user
     *
     * @param userDto
     * @return
     */
    UserDto updateProfile(UserDto userDto);

    /**
     * Update password
     *
     * @param newPassword
     * @return
     */
    UserDto changePassword(UserDto userDto, String newPassword);



}
