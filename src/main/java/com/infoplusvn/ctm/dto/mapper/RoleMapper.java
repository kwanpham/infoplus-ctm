package com.infoplusvn.ctm.dto.mapper;

import com.infoplusvn.ctm.entity.Role;
import com.infoplusvn.ctm.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto entityToDto(Role role);

}
