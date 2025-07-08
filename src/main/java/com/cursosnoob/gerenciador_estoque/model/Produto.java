package com.cursosnoob.gerenciador_estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;
    private String codigo;
    private double preco;
    private int quantidade;

    @Enumerated(EnumType.STRING) // Informa ao JPA para salvar o nome do enum como String no banco
    private NivelEstoque nivelEstoque;

    // Enum para os níveis de estoque (definido dentro da classe ou em arquivo separado)
    public enum NivelEstoque {
        CRITICO,
        BAIXO,
        ADEQUADO,
        ALTO
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public NivelEstoque getNivelEstoque() {
        return nivelEstoque;
    }

    public void setNivelEstoque(NivelEstoque nivelEstoque) {
        this.nivelEstoque = nivelEstoque;
    }
}