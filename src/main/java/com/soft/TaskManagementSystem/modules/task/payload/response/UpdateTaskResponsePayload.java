package com.soft.TaskManagementSystem.modules.task.payload.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateTaskResponsePayload {
    private String taskId;
    private String userId;
    private String taskContent;
    private String taskPriority;
    private String taskStatus;
    private LocalDateTime updatedAt;
}
