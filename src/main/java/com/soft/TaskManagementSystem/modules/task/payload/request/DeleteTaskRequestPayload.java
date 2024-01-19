package com.soft.TaskManagementSystem.modules.task.payload.request;

import lombok.Data;

@Data
public class DeleteTaskRequestPayload {
    private String taskId;
    private String userId;
}
