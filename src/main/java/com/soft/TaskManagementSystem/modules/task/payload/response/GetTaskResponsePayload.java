package com.soft.TaskManagementSystem.modules.task.payload.response;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetTaskResponsePayload {
    private String taskId;
    private String userId;
    private String TaskTitle;
    private String taskContent;
    private String taskStatus;
    private String taskPriority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
