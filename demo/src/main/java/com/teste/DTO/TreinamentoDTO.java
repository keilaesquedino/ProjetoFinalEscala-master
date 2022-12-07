package com.teste.DTO;

import com.teste.Model.Treinamento;

public class TreinamentoDTO {

    private Long id;
    private String nome;
    private String descricao;

    public TreinamentoDTO() {
    }

    public TreinamentoDTO(Treinamento treinamento) {
        this.id = treinamento.getId();
        this.nome = treinamento.getNome();
        this.descricao = treinamento.getDescricao();
    }

    public TreinamentoDTO(Long id, String nome, String descricao) {
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
