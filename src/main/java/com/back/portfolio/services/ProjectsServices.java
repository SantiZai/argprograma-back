package com.back.portfolio.services;

import com.back.portfolio.entities.Project;
import com.back.portfolio.repositories.IProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProjectsServices {
    @Autowired
    IProjectsRepository projectsRepository;

    public ArrayList<Project> bringProjects() { return (ArrayList<Project>) projectsRepository.findAll(); }

    public Optional<Project> bringProject(Long id) { return projectsRepository.findById(id); }

    public Project saveProject(Project project) { return projectsRepository.save(project); }

    public Project updateProject(Project request, Long id) {
        Optional<Project> optionalProject = projectsRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            if (request.getName() != null) project.setName(request.getName());
            if (request.getDescription() != null) project.setDescription(request.getDescription());
            if (request.getLink() != null) project.setLink(request.getLink());
            return this.projectsRepository.save(project);
        } else {
            throw new Error("Task with id: " + id + " not found.");
        }
    }

    public Boolean deleteProject(Long id) {
        try {
            this.projectsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
