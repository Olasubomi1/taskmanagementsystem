package com.soft.TaskManagementSystem.modules.user.service;

import com.soft.TaskManagementSystem.config.MessageProvider;
import com.soft.TaskManagementSystem.constants.Creator;
import com.soft.TaskManagementSystem.constants.ResponseCode;
import com.soft.TaskManagementSystem.constants.RoleName;
import com.soft.TaskManagementSystem.dto.ErrorResponse;
import com.soft.TaskManagementSystem.dto.PayloadResponse;
import com.soft.TaskManagementSystem.dto.ServerResponse;
import com.soft.TaskManagementSystem.modules.user.model.User;
import com.soft.TaskManagementSystem.modules.user.payload.request.SignupUserRequestPayload;
import com.soft.TaskManagementSystem.modules.user.payload.response.SignupUserResponsePayload;
import com.soft.TaskManagementSystem.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageProvider messageProvider;

    @Override
    public ServerResponse signupUser(SignupUserRequestPayload requestPayload) {
        String responseCode = ResponseCode.SYSTEM_ERROR;
        String responseMessage = messageProvider.getMessage(responseCode);
        ErrorResponse errorResponse = ErrorResponse.getInstance();

        // Check if the user already exist in database by email, username and phone number
        User userByEmail = userRepository.findByEmailAddress(requestPayload.getEmailAddress());
        if(userByEmail != null){
            responseCode = ResponseCode.RECORD_ALREADY_EXIST_BY_EMAIL;
            responseMessage = messageProvider.getMessage(responseCode);
            errorResponse.setResponseCode(responseCode);
            errorResponse.setResponseMessage(responseMessage);
            return errorResponse;
        }

        // Check if the user exists by username
        User userByUsername = userRepository.findByUsername(requestPayload.getUsername());
        if(userByUsername != null){
            responseCode = ResponseCode.RECORD_ALREADY_EXIST_BY_USERNAME;
            responseMessage = messageProvider.getMessage(responseCode);
            errorResponse.setResponseCode(responseCode);
            errorResponse.setResponseMessage(responseMessage);
            return errorResponse;
        }

        // Check if the user already exists by mobileNumber.
        User userByMobileNumber = userRepository.findByMobileNumber(requestPayload.getMobileNumber());
        if(userByMobileNumber != null) {
            responseCode = ResponseCode.RECORD_ALREADY_EXIST_BY_MOBILE_NUMBER;
            responseMessage = messageProvider.getMessage(responseCode);
            errorResponse.setResponseCode(responseCode);
            errorResponse.setResponseMessage(responseMessage);
            return errorResponse;
        }

        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUsername(requestPayload.getUsername());
        user.setEmailAddress(requestPayload.getEmailAddress());
        user.setMobileNumber(requestPayload.getMobileNumber());
        user.setPassword(requestPayload.getPassword());
        user.setGender(requestPayload.getGender().toUpperCase());
        user.setAuthToken("soft");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy(Creator.SYSTEM.name());
        user.setModifiedBy(Creator.SYSTEM.name());
        user.setUpdatedAt(LocalDateTime.now());
        user.setLastLoginDate(LocalDateTime.now());
        user.setUserRoleName(RoleName.USER.name());
        user.setLoginAttempt(0);
        User savedUser = userRepository.saveAndFlush(user);

        SignupUserResponsePayload responsePayload = new SignupUserResponsePayload();
        responsePayload.setAuthToken(savedUser.getAuthToken());
        responsePayload.setUsername(savedUser.getUsername());
        responsePayload.setCreatedAt(savedUser.getCreatedAt());
        responsePayload.setUpdatedAt(savedUser.getUpdatedAt());

        responseCode = ResponseCode.SUCCESS;
        responseMessage = messageProvider.getMessage(responseCode);
        PayloadResponse response = PayloadResponse.getInstance();
        response.setResponseCode(responseCode);
        response.setResponseMessage(responseMessage);
        response.setResponseData(responsePayload);
        return response;
    }
}
