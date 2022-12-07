package com.teste.DTO;

import com.teste.Model.Skill_User;

public class Skill_UserDTO {

    private Long id;
    private String nome;

    private SkillDTO skill;

    public Skill_UserDTO() {
    }

    public Skill_UserDTO(Skill_User skill_user) {
        this.id = skill_user.getId();
        this.nome = skill_user.getNome();
        this.skill = new SkillDTO(skill_user.getSkill());
    }

    public Skill_UserDTO(Long id, String nome, SkillDTO skill) {
        this.id = id;
        this.nome = nome;
        this.skill = skill;
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

    public SkillDTO getSkill() {
        return skill;
    }

    public void setSkill(SkillDTO skill) {
        this.skill = skill;
    }
}
