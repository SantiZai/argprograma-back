package com.back.portfolio.repositories;

import com.back.portfolio.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectsRepository extends JpaRepository<Project, Long> {
}
