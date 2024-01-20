package com.soft.TaskManagementSystem.modules.task.payload.response;

import com.soft.TaskManagementSystem.modules.task.model.Task;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class GetTaskPaginationResponsePayload {
    Page<Task> tasks;
}
