package com.soft.TaskManagementSystem.modules.task.repository;

import com.soft.TaskManagementSystem.modules.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTaskId(String userId);
}
