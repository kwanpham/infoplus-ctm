package com.infoplusvn.ctm.controller.v1.api;

import com.infoplusvn.ctm.controller.v1.api.request.LoginRequest;
import com.infoplusvn.ctm.dto.response.ResponseError;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by https://github.com/kwanpham
 */

@RestController
@RequestMapping("/api")
public class AuthController {

    @ApiOperation("Login")
    @PostMapping(value = "/auth")
    public ResponseEntity restLogin(@RequestBody @Valid LoginRequest loginRequest) {
        ResponseError responseError = new ResponseError()
                .setTimestamp(new Date())
                .setMessage("login failed")
                .setDetails("wrong username or password");
        return ResponseEntity.ok(responseError);
    }

//    @ApiOperation("Logout")
//    @PostMapping("/logout")
//    public void fakeLogout() {
//        throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
//    }

}
