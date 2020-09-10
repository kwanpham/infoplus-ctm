package com.infoplusvn.ctm.controller.v1.api.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

/**
 * Created by https://github.com/kwanpham
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSignupRequest {


    @ApiModelProperty(example = "quanph" ,  name = "Username" , position = 1)
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String username;

    @ApiModelProperty(example = "quan@infoplus.com" ,  name = "Email" , position = 2)
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String email;

    @ApiModelProperty(example = "12345" ,  name = "Password" , position = 3)
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String password;

}