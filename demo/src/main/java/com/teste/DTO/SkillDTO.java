package com.teste.DTO;

import com.teste.Model.Skill;

public class SkillDTO {

    private Long id;
    private String nome;
    private String descricao;

    public SkillDTO() {
    }

    public SkillDTO(Skill skill) {
        this.id = skill.getId();
        this.nome = skill.getNome();
        this.descricao = skill.getDescricao();
    }

    public SkillDTO(Long id, String nome, String descricao) {
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
