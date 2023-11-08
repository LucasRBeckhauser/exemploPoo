package com.senac.exemplo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Cliente extends Pessoa{

    private String cpf;
    private Double limiteCredito;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

}
