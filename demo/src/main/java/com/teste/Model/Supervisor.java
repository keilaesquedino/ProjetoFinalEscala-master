package com.teste.Model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "supervisor")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 90, nullable = false )
    private String nome;

    @Column(name = "data_admissao", nullable = false )
    private LocalDate data_admissao;

    @Column(name = "funcionario", length = 90, nullable = false )
    private String funcionario;

    @JsonIgnore
    @OneToMany(mappedBy = "skill_user")
    private List<Operador> operadores = new ArrayList<>();

    public Supervisor() {
    }

    public Supervisor(Long id, String nome, LocalDate data_admissao, String funcionario) {
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

    public List<Operador> getOperadores() {
        return operadores;
    }
}

