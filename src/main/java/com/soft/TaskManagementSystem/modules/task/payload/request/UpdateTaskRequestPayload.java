package com.soft.TaskManagementSystem.modules.task.payload.request;

import lombok.Data;

@Data
public class UpdateTaskRequestPayload {
    private String userId;
    private String taskId;
    private String taskContent;
    private String taskPriority;
    private String taskStatus;
}
