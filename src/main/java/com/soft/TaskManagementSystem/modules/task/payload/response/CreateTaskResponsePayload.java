package com.soft.TaskManagementSystem.modules.task.payload.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTaskResponsePayload {
    private String taskId;
    private String userId;
    private String taskTitle;
    private String taskContent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
