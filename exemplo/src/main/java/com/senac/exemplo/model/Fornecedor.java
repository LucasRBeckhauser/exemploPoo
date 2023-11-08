package com.senac.exemplo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class Fornecedor extends Pessoa{

    @Column(name = "cnpj",nullable = true)
    private String cnpj;
    @Column(name = "razao_social",nullable = true)
    private String razaoSocial;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
