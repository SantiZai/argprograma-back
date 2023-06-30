package com.back.portfolio.services;

import com.back.portfolio.entities.ProjectSkill;
import com.back.portfolio.entities.Skill;
import com.back.portfolio.repositories.IProjectSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectSkillServices {
    @Autowired
    IProjectSkillRepository projectSkillRepository;

    public ArrayList<ProjectSkill> bringProjectSkills() { return (ArrayList<ProjectSkill>) projectSkillRepository.findAll(); }

    public Optional<ProjectSkill> bringProjectSkill(Long id) { return projectSkillRepository.findById(id); }

    public ProjectSkill saveProjectSkill(ProjectSkill projectSkill) { return projectSkillRepository.save(projectSkill); }

    public Boolean deleteProjectSkill(Long id) {
        try {
            this.projectSkillRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ProjectSkill> getSkillsByProjectId(Long projectId) { return projectSkillRepository.findByProjectId(projectId); }
}
