package com.project.management.project_management.service;

import com.project.management.project_management.handle_exception.ResourceNotFoundException;
import com.project.management.project_management.model.Resource;
import com.project.management.project_management.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource saveResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

    // Method to get a resource by its ID
    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    // Method to update the resource
    public void updateResource(Resource resource) {
        resourceRepository.save(resource);
    }
}
