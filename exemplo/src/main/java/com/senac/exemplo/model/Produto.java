package com.senac.exemplo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Produto extends EntityId {

    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "valor", nullable = false)
    private Double valor;




    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
