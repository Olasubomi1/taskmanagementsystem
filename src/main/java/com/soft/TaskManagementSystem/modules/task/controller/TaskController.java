package com.soft.TaskManagementSystem.modules.task.controller;

import com.soft.TaskManagementSystem.dto.ServerResponse;
import com.soft.TaskManagementSystem.modules.task.payload.request.CreateTaskRequestPayload;
import com.soft.TaskManagementSystem.modules.task.payload.request.DeleteTaskRequestPayload;
import com.soft.TaskManagementSystem.modules.task.payload.request.GetTaskPaginationRequestPayload;
import com.soft.TaskManagementSystem.modules.task.payload.request.UpdateTaskRequestPayload;
import com.soft.TaskManagementSystem.modules.task.service.TaskService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/createTask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServerResponse> createTask(@Valid @RequestBody CreateTaskRequestPayload requestPayload){
        ServerResponse serverResponse = taskService.createTask(requestPayload);
        return ResponseEntity.ok(serverResponse);
    }

    @PutMapping(value = "/updateTask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServerResponse> updateTask(@Valid @RequestBody UpdateTaskRequestPayload requestPayload){
        ServerResponse serverResponse = taskService.updateTask(requestPayload);
        return ResponseEntity.ok(serverResponse);
    }

    @DeleteMapping(value = "/deleteTask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServerResponse> deleteTask(@Valid @RequestBody DeleteTaskRequestPayload requestPayload){
        ServerResponse serverResponse = taskService.deleteTask(requestPayload);
        return ResponseEntity.ok(serverResponse);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ServerResponse> getTask(@PathVariable String id){
        ServerResponse serverResponse = taskService.getTask(id);
        return ResponseEntity.ok(serverResponse);
    }

    @GetMapping(value = "/{pageNumber}/{pageSize}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServerResponse> getPaginatedTasks(@Valid @RequestBody GetTaskPaginationRequestPayload requestPayload, @PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        ServerResponse serverResponse = taskService.getTaskPagination(requestPayload, pageNumber, pageSize);
        return ResponseEntity.ok(serverResponse);
    }
}
