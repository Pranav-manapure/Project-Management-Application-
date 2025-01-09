package com.project.management.project_management.service;

import com.project.management.project_management.handle_exception.ResourceNotFoundException;
import com.project.management.project_management.model.Task;
import com.project.management.project_management.repository.TaskRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Method to get a task by its ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    // Method to update the task
    public void updateTask(Task task) {
        taskRepository.save(task);
    }
}
