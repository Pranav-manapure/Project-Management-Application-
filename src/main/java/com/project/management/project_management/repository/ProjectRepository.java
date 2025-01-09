package com.project.management.project_management.repository;

import com.project.management.project_management.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}