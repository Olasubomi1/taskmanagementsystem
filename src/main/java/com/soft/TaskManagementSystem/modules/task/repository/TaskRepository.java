package com.soft.TaskManagementSystem.modules.task.repository;

import com.soft.TaskManagementSystem.modules.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByUserId(String userId);
}
