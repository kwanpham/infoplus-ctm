package com.infoplusvn.ctm.controller.v1.api;


import com.infoplusvn.ctm.controller.v1.api.request.UserSignupRequest;
import com.infoplusvn.ctm.dto.UserDto;
import com.infoplusvn.ctm.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by https://github.com/kwanpham
 */

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Add a user", response = UserDto.class)
    @PostMapping("/signup")
    public ResponseEntity signup(@ApiParam(value = "user , email , password", required = true) @RequestBody @Valid UserSignupRequest userSignupRequest) {
        return ResponseEntity.ok(registerUser(userSignupRequest));
    }

    /**
     * Register a new user in the database
     *
     * @param userSignupRequest
     * @return
     */
    private UserDto registerUser(UserSignupRequest userSignupRequest) {
        UserDto userDto = new UserDto()
                .setEmail(userSignupRequest.getEmail())
                .setUsername(userSignupRequest.getUsername())
               .setPassword(userSignupRequest.getPassword());


        return userService.signup(userDto);
    }


}
