package com.soft.TaskManagementSystem.modules.task.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetTaskPaginationRequestPayload {
    @NotNull
    private String userId;
}
