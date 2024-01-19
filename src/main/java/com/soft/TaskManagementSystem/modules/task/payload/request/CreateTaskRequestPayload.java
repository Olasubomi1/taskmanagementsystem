package com.soft.TaskManagementSystem.modules.task.payload.request;

import com.soft.TaskManagementSystem.modules.user.model.User;
import lombok.Data;

@Data
public class CreateTaskRequestPayload {
    private String userId;
    private String taskTitle;
    private String taskContent;
    private String taskStatus;
    private String taskPriority;
}
