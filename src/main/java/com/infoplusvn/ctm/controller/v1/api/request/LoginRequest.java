package com.infoplusvn.ctm.controller.v1.api.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * Created by https://github.com/kwanpham
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {

    @ApiModelProperty(example = "quanph" , position = 1 , name = "Username" , required = true)
    @NotNull(message = "{constraints.NotEmpty.message}")
    private String username;


    @ApiModelProperty(example = "12345" , position = 2 , name = "Password" , required = true)
    @NotNull(message = "{constraints.NotEmpty.message}")
    private String password;

}
