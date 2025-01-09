package com.project.management.project_management.repository;

import com.project.management.project_management.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
