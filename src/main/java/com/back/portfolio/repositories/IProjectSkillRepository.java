package com.back.portfolio.repositories;

import com.back.portfolio.entities.ProjectSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProjectSkillRepository extends JpaRepository<ProjectSkill, Long> {
    @Query("SELECT ps FROM ProjectSkill ps WHERE ps.project_id = :projectId")
    List<ProjectSkill> findByProjectId(@Param("projectId") Long projectId);
}
