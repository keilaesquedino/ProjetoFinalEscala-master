package com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.Model.Skill_User;

@Repository
public interface Skill_UserRepository extends JpaRepository <Skill_User, Long> {

}
