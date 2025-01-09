package com.project.management.project_management.repository;

import com.project.management.project_management.model.Project;
import com.project.management.project_management.model.Resource;
import com.project.management.project_management.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
    long countByResourceAndProject(Resource resource, Project project);
}