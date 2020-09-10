package com.infoplusvn.ctm.dto.mapper;

import com.infoplusvn.ctm.dto.UserDto;
import com.infoplusvn.ctm.entity.User;
import com.infoplusvn.ctm.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "roleList" , target = "roleDtos" , qualifiedByName = "roleDtos")
    UserDto entityToDto(User user);

    User dtoToEntity(UserDto userDto);

    @Named("roleDtos")
    default Set<RoleDto> rolesToRoleDtos(User user) {
        return user.getRoleList().stream()
                .map(role -> new RoleDto(role.getName()))
                .collect(Collectors.toSet());
    }


}
