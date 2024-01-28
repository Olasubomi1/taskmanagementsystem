package com.soft.TaskManagementSystem.modules.task.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateTaskRequestPayload {
    @NotNull
    private String userId;
    @NotNull
    private String taskId;
    private String taskContent;
    private String taskPriority;
    private String taskStatus;
}
