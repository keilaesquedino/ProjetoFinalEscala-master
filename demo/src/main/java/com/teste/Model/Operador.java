package com.teste.Model;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operador")
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 90, nullable = false )
    private String nome;

    @Column(name = "data_admissao", nullable = false )
    private LocalDate data_admissao;

    @Column(name = "regime_trabalho", length = 90, nullable = false )
    private String regime_trabalho;

    @Column(name = "cargo", length = 90, nullable = false )
    private String cargo;

    @Column(name = "skill", length = 90, nullable = false )
    private String skill;

    @ManyToOne
    @JoinColumn(name = "id_skilluser")
    private Skill_User skill_user;

    @ManyToOne
    @JoinColumn(name = "id_supervisor")
    private Supervisor supervisor;

    public Operador() {
    }

    public Operador(Long id, String nome, LocalDate data_admissao, String regime_trabalho, String cargo, String skill,
                    Skill_User skill_user, Supervisor supervisor) {
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

    public Skill_User getSkill_user() {
        return skill_user;
    }

    public void setSkill_user(Skill_User skill_user) {
        this.skill_user = skill_user;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}