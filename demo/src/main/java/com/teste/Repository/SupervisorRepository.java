package com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.Model.Supervisor;

@Repository
public interface SupervisorRepository extends JpaRepository <Supervisor, Long> {

}
