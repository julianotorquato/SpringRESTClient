package com.concretepage;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Juliano Torquato on 23/11/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Conta {

    private Long idConta;
    private String nome;
    private Double vlInicial;

    public Conta(){ }

    public Conta(String nome, Double vlInicial) {
        this.nome = nome;
        this.vlInicial = vlInicial;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getVlInicial() {
        return vlInicial;
    }

    public void setVlInicial(Double vlInicial) {
        this.vlInicial = vlInicial;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((vlInicial == null) ? 0 : vlInicial.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (idConta == null) {
            if (other.idConta != null)
                return false;
        } else if (!idConta.equals(other.idConta))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (vlInicial == null) {
            if (other.vlInicial != null)
                return false;
        } else if (!vlInicial.equals(other.vlInicial))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Conta [idConta=" + idConta + ", nome=" + nome + ", vlInicial=" + vlInicial + "]";
    }

}
