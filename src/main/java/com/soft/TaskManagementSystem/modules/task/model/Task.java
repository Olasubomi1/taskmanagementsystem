package com.soft.TaskManagementSystem.modules.task.model;

import com.soft.TaskManagementSystem.modules.user.model.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tms_task")
@Data
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_id")
    private String taskId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "task_title")
    private String TaskTitle;

    @Column(name = "task_content")
    private String taskContent;

    @Column(name = "task_status")
    private String taskStatus;

    @Column(name = "task_priority")
    private String taskPriority;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
