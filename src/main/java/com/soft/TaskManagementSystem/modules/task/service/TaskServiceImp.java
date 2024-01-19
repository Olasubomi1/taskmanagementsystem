package com.soft.TaskManagementSystem.modules.task.service;

import com.soft.TaskManagementSystem.config.MessageProvider;
import com.soft.TaskManagementSystem.constants.ResponseCode;
import com.soft.TaskManagementSystem.dto.ErrorResponse;
import com.soft.TaskManagementSystem.dto.PayloadResponse;
import com.soft.TaskManagementSystem.dto.ServerResponse;
import com.soft.TaskManagementSystem.modules.task.model.Task;
import com.soft.TaskManagementSystem.modules.task.payload.request.CreateTaskRequestPayload;
import com.soft.TaskManagementSystem.modules.task.payload.request.UpdateTaskRequestPayload;
import com.soft.TaskManagementSystem.modules.task.payload.response.CreateTaskResponsePayload;
import com.soft.TaskManagementSystem.modules.task.payload.response.UpdateTaskResponsePayload;
import com.soft.TaskManagementSystem.modules.task.repository.TaskRepository;
import com.soft.TaskManagementSystem.modules.user.model.User;
import com.soft.TaskManagementSystem.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TaskServiceImp implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageProvider messageProvider;

    @Override
    public ServerResponse createTask(CreateTaskRequestPayload requestPayload) {
        String responseCode = ResponseCode.SYSTEM_ERROR;
        String responseMessage = messageProvider.getMessage(responseCode);
        ErrorResponse errorResponse = ErrorResponse.getInstance();

        // Check if user exist by userId
        User userByUserId = userRepository.findByUserId(requestPayload.getUserId());
        if (userByUserId == null){
            responseCode = ResponseCode.RECORD_NOT_FOUND;
            responseMessage = messageProvider.getMessage(responseCode);
            errorResponse.setResponseCode(responseCode);
            errorResponse.setResponseMessage(responseMessage);
            return errorResponse;
        }

        Task task = new Task();
        task.setTaskId(UUID.randomUUID().toString());
        task.setUserId(userByUserId.getUserId());
        task.setTaskTitle(requestPayload.getTaskTitle());
        task.setTaskContent(requestPayload.getTaskContent());
        task.setTaskPriority(requestPayload.getTaskPriority().toUpperCase());
        task.setTaskStatus(requestPayload.getTaskStatus());
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        Task savedTask = taskRepository.saveAndFlush(task);

        CreateTaskResponsePayload responsePayload = new CreateTaskResponsePayload();
        responsePayload.setTaskId(savedTask.getTaskId());
        responsePayload.setUserId(savedTask.getUserId());
        responsePayload.setTaskTitle(savedTask.getTaskTitle());
        responsePayload.setTaskContent(savedTask.getTaskContent());
        responsePayload.setCreatedAt(savedTask.getCreatedAt());
        responsePayload.setUpdatedAt(savedTask.getUpdatedAt());

        responseCode = ResponseCode.SUCCESS;
        responseMessage = messageProvider.getMessage(responseCode);
        PayloadResponse response = PayloadResponse.getInstance();
        response.setResponseCode(responseCode);
        response.setResponseMessage(responseMessage);
        response.setResponseData(responsePayload);
        return response;
    }

    @Override
    public ServerResponse updateTask(UpdateTaskRequestPayload requestPayload) {
        String responseCode = ResponseCode.SYSTEM_ERROR;
        String responseMessage = messageProvider.getMessage(responseCode);
        ErrorResponse errorResponse = ErrorResponse.getInstance();

        // Check if user exist by userId
        User userByUserId = userRepository.findByUserId(requestPayload.getUserId());
        if (userByUserId == null){
            responseCode = ResponseCode.RECORD_NOT_FOUND;
            responseMessage = messageProvider.getMessage(responseCode);
            errorResponse.setResponseCode(responseCode);
            errorResponse.setResponseMessage(responseMessage);
            return errorResponse;
        }

        //Check if task exist with userId
        Task task = taskRepository.findByUserId(userByUserId.getUserId());
        if (task == null){
            responseCode = ResponseCode.TASK_NOT_FOUND;
            responseMessage = messageProvider.getMessage(responseCode);
            errorResponse.setResponseCode(responseCode);
            errorResponse.setResponseMessage(responseMessage);
            return errorResponse;
        }

        // Update task properties
        task.setTaskContent(requestPayload.getTaskContent());
        task.setUpdatedAt(LocalDateTime.now());
        taskRepository.saveAndFlush(task);

        UpdateTaskResponsePayload responsePayload = new UpdateTaskResponsePayload();
        responsePayload.setUserId(task.getUserId());
        responsePayload.setTaskId(task.getTaskId());
        responsePayload.setTaskContent(task.getTaskContent());
        responsePayload.setUpdatedAt(task.getUpdatedAt());

        responseCode = ResponseCode.SUCCESS;
        responseMessage = messageProvider.getMessage(responseCode);
        PayloadResponse response = PayloadResponse.getInstance();
        response.setResponseCode(responseCode);
        response.setResponseMessage(responseMessage);
        response.setResponseData(responsePayload);
        return response;
    }
}
