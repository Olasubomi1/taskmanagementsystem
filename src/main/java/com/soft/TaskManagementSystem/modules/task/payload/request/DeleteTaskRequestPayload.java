package com.soft.TaskManagementSystem.modules.task.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeleteTaskRequestPayload {
    @NotNull
    private String taskId;
    @NotNull
    private String userId;
}
