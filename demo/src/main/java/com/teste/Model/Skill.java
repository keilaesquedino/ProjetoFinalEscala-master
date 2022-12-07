package com.teste.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 90, nullable = false )
    private String nome;

    @Column(name = "descricao", length = 240, nullable = false )
    private String descricao;

    @ManyToMany
    // @JoinColumn(name = "id_operador")
    @JoinTable(name ="skill_user",
            joinColumns = @JoinColumn(name= "skill_id",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name= "User_id", referencedColumnName = "ID"))

    @JsonIgnore
    private List<Skill_User> usuarios = new ArrayList<>();

    public Skill() {
    }

    public Skill(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}