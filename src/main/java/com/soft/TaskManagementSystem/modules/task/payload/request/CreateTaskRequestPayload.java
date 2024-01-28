package com.soft.TaskManagementSystem.modules.task.payload.request;

import com.soft.TaskManagementSystem.modules.user.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTaskRequestPayload {
    @NotNull
    private String userId;
    private String taskTitle;
    private String taskContent;
    private String taskStatus;
    private String taskPriority;
}
