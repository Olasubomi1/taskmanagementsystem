package com.soft.TaskManagementSystem.modules.user.controller;

import com.soft.TaskManagementSystem.dto.ServerResponse;
import com.soft.TaskManagementSystem.modules.user.payload.request.SignupUserRequestPayload;
import com.soft.TaskManagementSystem.modules.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServerResponse> signupUser(@RequestBody SignupUserRequestPayload requestPayload){
        // TODO: Validation of the request body.
        ServerResponse serverResponse = userService.signupUser(requestPayload);
        return ResponseEntity.ok(serverResponse);
    }
}
