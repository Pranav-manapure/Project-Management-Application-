package com.project.management.project_management.validation;

import com.project.management.project_management.model.Task;
import com.project.management.project_management.repository.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskAssignmentValidator {
    private final TaskRepository taskRepository;

    public TaskAssignmentValidator(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public boolean validateTaskAssignment(Task task) {
        if (task.getResource() == null) return true;

        long taskCount = taskRepository.countByResourceAndProject(task.getResource(), task.getProject());
        return taskCount < 2;
    }
}
