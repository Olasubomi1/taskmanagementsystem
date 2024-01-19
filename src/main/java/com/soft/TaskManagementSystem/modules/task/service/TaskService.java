package com.soft.TaskManagementSystem.modules.task.service;

import com.soft.TaskManagementSystem.dto.ServerResponse;
import com.soft.TaskManagementSystem.modules.task.payload.request.CreateTaskRequestPayload;
import com.soft.TaskManagementSystem.modules.task.payload.request.UpdateTaskRequestPayload;

public interface TaskService {
    ServerResponse createTask(CreateTaskRequestPayload requestPayload);
    ServerResponse updateTask(UpdateTaskRequestPayload requestPayload);
//    ServerResponse deleteTask();
}
