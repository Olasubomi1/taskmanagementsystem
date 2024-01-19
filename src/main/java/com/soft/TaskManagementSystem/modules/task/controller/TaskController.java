package com.soft.TaskManagementSystem.modules.task.controller;

import com.soft.TaskManagementSystem.dto.ServerResponse;
import com.soft.TaskManagementSystem.modules.task.payload.request.CreateTaskRequestPayload;
import com.soft.TaskManagementSystem.modules.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/createTask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServerResponse> createTask(@RequestBody CreateTaskRequestPayload requestPayload){
        // TODO: Validation of the request body.
        ServerResponse serverResponse = taskService.createTask(requestPayload);
        return ResponseEntity.ok(serverResponse);
    }
}
