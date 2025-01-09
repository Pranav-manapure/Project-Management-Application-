package com.project.management.project_management.controller;

import com.project.management.project_management.model.Task;
import com.project.management.project_management.service.ProjectService;
import com.project.management.project_management.service.ResourceService;
import com.project.management.project_management.service.TaskService;
import com.project.management.project_management.validation.TaskAssignmentValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final ProjectService projectService;
    private final ResourceService resourceService;
    private final TaskAssignmentValidator validator;

    public TaskController(TaskService taskService, ProjectService projectService, ResourceService resourceService, TaskAssignmentValidator validator) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.resourceService = resourceService;
        this.validator = validator;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks/list";
    }

    @GetMapping("/create")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("resources", resourceService.getAllResources());
        return "tasks/create";
    }

    @PostMapping
    public String saveTask(@ModelAttribute Task task, Model model) {
        if (!validator.validateTaskAssignment(task)) {
            model.addAttribute("error", "Resource is over-allocated.");
            return "tasks/create";
        }
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    // Display the update form with current task details
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "tasks/update";  // returns tasks/update.html
    }

    // Handle the update request and save the updated task
    @PostMapping("/update")
    public String updateTask(@ModelAttribute("task") Task task) {
        taskService.updateTask(task);
        return "redirect:/tasks";  // Redirect to the tasks list after update
    }
}
