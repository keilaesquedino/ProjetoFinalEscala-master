package com.teste.DTO;

import java.time.LocalDate;

import com.teste.Model.Operador;

public class OperadorDTO {

    private Long id;
    private String nome;
    private LocalDate data_admissao;
    private String regime_trabalho;
    private String cargo;
    private String skill;

    private Skill_UserDTO skill_user;
    private SupervisorDTO supervisor;

    public OperadorDTO() {
    }

    public OperadorDTO(Operador operador) {
        this.id = operador.getId();
        this.nome = operador.getNome();
        this.data_admissao = operador.getData_admissao();
        this.regime_trabalho = operador.getRegime_trabalho();
        this.cargo = operador.getCargo();
        this.skill = operador.getSkill();
        this.skill_user = new Skill_UserDTO(operador.getSkill_user());
        this.supervisor = new SupervisorDTO(operador.getSupervisor());
    }

    public OperadorDTO(Long id, String nome, LocalDate data_admissao, String regime_trabalho, String cargo,
                       String skill, Skill_UserDTO skill_user, SupervisorDTO supervisor) {
        this.id = id;
        this.nome = nome;
        this.data_admissao = data_admissao;
        this.regime_trabalho = regime_trabalho;
        this.cargo = cargo;
        this.skill = skill;
        this.skill_user = skill_user;
        this.supervisor = supervisor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(LocalDate data_admissao) {
        this.data_admissao = data_admissao;
    }

    public String getRegime_trabalho() {
        return regime_trabalho;
    }

    public void setRegime_trabalho(String regime_trabalho) {
        this.regime_trabalho = regime_trabalho;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Skill_UserDTO getSkill_user() {
        return skill_user;
    }

    public void setSkill_user(Skill_UserDTO skill_user) {
        this.skill_user = skill_user;
    }

    public SupervisorDTO getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(SupervisorDTO supervisor) {
        this.supervisor = supervisor;
    }
}
