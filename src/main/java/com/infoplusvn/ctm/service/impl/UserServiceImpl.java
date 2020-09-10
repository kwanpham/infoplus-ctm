package com.infoplusvn.ctm.service.impl;

import com.infoplusvn.ctm.constant.SystemConstant;
import com.infoplusvn.ctm.constant.UserRoles;
import com.infoplusvn.ctm.entity.Role;
import com.infoplusvn.ctm.entity.User;
import com.infoplusvn.ctm.exception.CTMException;
import com.infoplusvn.ctm.exception.EntityType;
import com.infoplusvn.ctm.exception.ExceptionType;
import com.infoplusvn.ctm.dto.UserDto;
import com.infoplusvn.ctm.dto.mapper.UserMapper;
import com.infoplusvn.ctm.repo.RoleRepo;
import com.infoplusvn.ctm.repo.UserRepo;
import com.infoplusvn.ctm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static com.infoplusvn.ctm.exception.EntityType.USER;
import static com.infoplusvn.ctm.exception.ExceptionType.DUPLICATE_ENTITY;
import static com.infoplusvn.ctm.exception.ExceptionType.ENTITY_NOT_FOUND;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto signup(UserDto userDto) {
        Role userRole;
        User user = userRepo.findByUsername(userDto.getUsername());
        if (user == null) {

            userRole = roleRepo.findByName(UserRoles.admin.name());
            user = new User()
                    .setUsername(userDto.getUsername())
                    .setEmail(userDto.getEmail())
                    .setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()))
                    .setRoleList(new HashSet<>(Arrays.asList(userRole)))
                    .setStatus(SystemConstant.ACTIVE_STATUS);

            return userMapper.entityToDto(userRepo.save(user));
        }
        throw exception(USER, DUPLICATE_ENTITY, userDto.getEmail());
    }

    @Override
    public UserDto findUserByUsername(String username) {
        Optional<User> user = Optional.ofNullable(userRepo.findByUsername(username));
        if (user.isPresent()) {
            return userMapper.entityToDto(user.get());
        }
        return null;
    }

    @Override
    public UserDto updateProfile(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto changePassword(UserDto userDto, String newPassword) {
        return null;
    }

    /**
     * Returns a new RuntimeException
     *
     * @param entityType
     * @param exceptionType
     * @param args
     * @return
     */
    private RuntimeException exception(EntityType entityType, ExceptionType exceptionType, String... args) {
        return CTMException.throwException(entityType, exceptionType, args);
    }
}
