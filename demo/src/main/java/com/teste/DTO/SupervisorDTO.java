package com.teste.DTO;

import java.time.LocalDate;

import com.teste.Model.Supervisor;

public class SupervisorDTO {

    private Long id;
    private String nome;
    private LocalDate data_admissao;
    private String funcionario;

    public SupervisorDTO() {
    }

    public SupervisorDTO(Supervisor supervisor) {
        this.id = supervisor.getId();
        this.nome = supervisor.getNome();
        this.data_admissao = supervisor.getData_admissao();
        this.funcionario = supervisor.getFuncionario();
    }

    public SupervisorDTO(Long id, String nome, LocalDate data_admissao, String funcionario) {
        this.id = id;
        this.nome = nome;
        this.data_admissao = data_admissao;
        this.funcionario = funcionario;
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

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }
}