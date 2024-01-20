package com.soft.TaskManagementSystem.modules.task.service;

import com.soft.TaskManagementSystem.dto.ServerResponse;
import com.soft.TaskManagementSystem.modules.task.payload.request.CreateTaskRequestPayload;
import com.soft.TaskManagementSystem.modules.task.payload.request.DeleteTaskRequestPayload;
import com.soft.TaskManagementSystem.modules.task.payload.request.GetTaskPaginationRequestPayload;
import com.soft.TaskManagementSystem.modules.task.payload.request.UpdateTaskRequestPayload;

public interface TaskService {
    ServerResponse createTask(CreateTaskRequestPayload requestPayload);
    ServerResponse updateTask(UpdateTaskRequestPayload requestPayload);
    ServerResponse getTask(String id);
    ServerResponse getTaskPagination(GetTaskPaginationRequestPayload requestPayload, Integer pageNumber, Integer pageSize);
    ServerResponse deleteTask(DeleteTaskRequestPayload requestPayload);
}
