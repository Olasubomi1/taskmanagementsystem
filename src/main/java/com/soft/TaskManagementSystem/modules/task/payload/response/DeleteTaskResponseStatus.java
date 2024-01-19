package com.soft.TaskManagementSystem.modules.task.payload.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeleteTaskResponseStatus {
    private String status;
    private LocalDateTime timeDeleted;
}
