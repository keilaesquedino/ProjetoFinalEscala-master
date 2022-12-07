package com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.Model.Operador;

@Repository
public interface OperadorRepository extends JpaRepository <Operador, Long> {

}
