package com.infoplusvn.ctm.controller.v1.ui.command;

import com.infoplusvn.ctm.custom.validator.FieldMatch;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by Arpit Khandelwal.
 */
@Data
@Accessors(chain = true)
@FieldMatch(first = "password", second = "repassword", message = "The password fields must match")
public class AdminSignupFormCommand {

    @NotBlank
    @Size(min = 5 , max = 50)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 5)
    private String password;

    @NotBlank
    @Size(min = 5)
    private String repassword;

}
