package com.back.portfolio.services;

import com.back.portfolio.entities.Skill;
import com.back.portfolio.entities.Skill;
import com.back.portfolio.repositories.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SkillsServices {
    @Autowired
    ISkillRepository skillRepository;

    public ArrayList<Skill> bringSkills() { return (ArrayList<Skill>) skillRepository.findAll(); }

    public Optional<Skill> bringSkill(Long id) { return skillRepository.findById(id); }

    public Skill saveSkill(Skill skill) { return skillRepository.save(skill); }

    public Skill updateSkill(Skill request, Long id) {
        Optional<Skill> optionalSkill = skillRepository.findById(id);
        if (optionalSkill.isPresent()) {
            Skill skill = optionalSkill.get();
            if (request.getType() != null) skill.setType(request.getType());
            if (request.getName() != null) skill.setName(request.getName());
            return this.skillRepository.save(skill);
        } else {
            throw new Error("Task with id: " + id + " not found.");
        }
    }

    public Boolean deleteSkill(Long id) {
        try {
            this.skillRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
