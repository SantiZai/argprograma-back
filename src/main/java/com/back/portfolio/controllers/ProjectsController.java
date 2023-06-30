package com.back.portfolio.controllers;

import com.back.portfolio.entities.Project;
import com.back.portfolio.services.ProjectsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectsController {
    @Autowired
    private ProjectsServices projectsServices;

    @GetMapping
    public ArrayList<Project> getProjects() { return this.projectsServices.bringProjects(); }

    @GetMapping(path = "/{id}")
    public Optional<Project> getProject(@PathVariable Long id) { return this.projectsServices.bringProject(id); }

    @PostMapping
    public Project createProject(@RequestBody Project project) { return this.projectsServices.saveProject(project); }

    @PatchMapping(path = "/{id}")
    public Project updateProject(@RequestBody Project project, @PathVariable Long id) { return this.projectsServices.updateProject(project, id); }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteProject(@PathVariable Long id) { return this.projectsServices.deleteProject(id); }
}
