package com.soft.TaskManagementSystem.modules.user.service;

import com.soft.TaskManagementSystem.dto.ServerResponse;
import com.soft.TaskManagementSystem.modules.user.payload.request.SignupUserRequestPayload;

public interface UserService {
    ServerResponse signupUser(SignupUserRequestPayload requestPayload);
}
