package com.back.portfolio.controllers;

import com.back.portfolio.entities.Skill;
import com.back.portfolio.services.SkillsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {
    @Autowired
    private SkillsServices skillsServices;

    @GetMapping
    public ArrayList<Skill> getSkills() { return this.skillsServices.bringSkills(); }

    @GetMapping(path = "/{id}")
    public Optional<Skill> getSkill(@PathVariable Long id) { return this.skillsServices.bringSkill(id); }

    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) { return this.skillsServices.saveSkill(skill); }

    @PatchMapping(path = "/{id}")
    public Skill updateSkill(@RequestBody Skill skill, @PathVariable Long id) { return this.skillsServices.updateSkill(skill, id); }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteSkill(@PathVariable Long id) { return this.skillsServices.deleteSkill(id); }
}
