package com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.Model.Skill;

@Repository
public interface SkillRepository extends JpaRepository <Skill, Long> {

}