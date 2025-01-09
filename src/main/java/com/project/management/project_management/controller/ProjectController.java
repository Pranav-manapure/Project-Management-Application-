package com.project.management.project_management.controller;

import com.project.management.project_management.model.Project;
import com.project.management.project_management.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects/list";
    }

    @GetMapping("/create")
    public String createProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "projects/create";
    }

    @PostMapping
    public String saveProject(@ModelAttribute Project project) {
        projectService.saveProject(project);
        return "redirect:/projects";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "redirect:/projects";
    }

    // Display the update form with current project details
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "projects/update";  // returns projects/update.html
    }

    // Handle the update request and save the updated project
    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project") Project project) {
        projectService.updateProject(project);
        return "redirect:/projects";  // Redirect to the project list after update
    }

}
