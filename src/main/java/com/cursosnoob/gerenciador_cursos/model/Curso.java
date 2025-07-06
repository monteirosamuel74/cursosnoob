package com.cursosnoob.gerenciador_cursos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Anotação que informa ao JPA que esta classe é uma entidade.
public class Curso {

    @Id // Define o campo como a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor do ID automaticamente.
    private Long id;

    private String nome;
    private int cargaHoraria;

    // Construtores, Getters e Setters (essenciais para o framework)
    public Curso() {}

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

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}