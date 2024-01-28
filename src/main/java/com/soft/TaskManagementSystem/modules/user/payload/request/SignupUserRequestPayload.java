package com.soft.TaskManagementSystem.modules.user.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupUserRequestPayload {
    @NotBlank
    private String username;
    @NotBlank
    private String mobileNumber;
    @NotBlank
    private String emailAddress;
    @NotBlank
    private String password;
    @NotBlank
    private String gender;
}
