package com.back.portfolio.controllers;

import com.back.portfolio.entities.ProjectSkill;
import com.back.portfolio.services.ProjectSkillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projectskill")
public class ProjectSkillController {
    @Autowired
    private ProjectSkillServices projectSkillServices;

    @GetMapping
    public ArrayList<ProjectSkill> getProjectSkills() { return this.projectSkillServices.bringProjectSkills(); }

    @GetMapping(path = "/{id}")
    public Optional<ProjectSkill> getProjectSkill(@PathVariable Long id) { return this.projectSkillServices.bringProjectSkill(id); }

    @GetMapping(path = "/{projectId}/skills")
    public List<ProjectSkill> getProjectSkillsByProjectId(@PathVariable Long projectId) { return this.projectSkillServices.getSkillsByProjectId(projectId); }

    @PostMapping
    public ProjectSkill createProjectSkill(@RequestBody ProjectSkill projectSkill) { return this.projectSkillServices.saveProjectSkill(projectSkill); }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteProjectSkill(@PathVariable Long id) { return this.projectSkillServices.deleteProjectSkill(id); }
}
