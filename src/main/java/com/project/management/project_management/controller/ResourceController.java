package com.project.management.project_management.controller;

import com.project.management.project_management.model.Resource;
import com.project.management.project_management.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resources")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public String listResources(Model model) {
        model.addAttribute("resources", resourceService.getAllResources());
        return "resources/list";
    }

    @GetMapping("/create")
    public String createResourceForm(Model model) {
        model.addAttribute("resource", new Resource());
        return "resources/create";
    }

    @PostMapping
    public String saveResource(@ModelAttribute Resource resource) {
        resourceService.saveResource(resource);
        return "redirect:/resources";
    }

    @GetMapping("/delete/{id}")
    public String deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return "redirect:/resources";
    }

    // Display the update form with current resource details
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Resource resource = resourceService.getResourceById(id);
        model.addAttribute("resource", resource);
        return "resources/update";  // returns resources/update.html
    }

    // Handle the update request and save the updated resource
    @PostMapping("/update")
    public String updateResource(@ModelAttribute("resource") Resource resource) {
        resourceService.updateResource(resource);
        return "redirect:/resources";  // Redirect to the resources list after update
    }
}