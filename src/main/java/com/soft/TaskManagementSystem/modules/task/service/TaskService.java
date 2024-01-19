package com.soft.TaskManagementSystem.modules.task.service;

import com.soft.TaskManagementSystem.dto.ServerResponse;
import com.soft.TaskManagementSystem.modules.task.payload.request.CreateTaskRequestPayload;

public interface TaskService {
    ServerResponse createTask(CreateTaskRequestPayload requestPayload);
//    ServerResponse updateTask();
//    ServerResponse deleteTask();
}
