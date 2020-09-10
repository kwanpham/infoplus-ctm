package com.infoplusvn.ctm.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
public class UserDto {


    private Integer id;


    private String username;

    @JsonIgnore
    private String password;


    private String email;


    private Integer status;


    private Set<RoleDto> roleDtos;



}
