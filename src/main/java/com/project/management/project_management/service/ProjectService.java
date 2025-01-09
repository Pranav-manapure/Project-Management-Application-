package com.project.management.project_management.service;

import com.project.management.project_management.handle_exception.ResourceNotFoundException;
import com.project.management.project_management.model.Project;
import com.project.management.project_management.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    // Method to get a project by its ID
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
    }

    // Method to update the project
    public void updateProject(Project project) {
        // Assuming Project already exists in the database
        projectRepository.save(project);
    }

}
