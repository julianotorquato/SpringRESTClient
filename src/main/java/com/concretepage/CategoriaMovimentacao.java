package com.concretepage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriaMovimentacao implements Serializable{

    private Long idCategoriaMovimentacao;
    private String nome;
    
    public CategoriaMovimentacao() { }

    public CategoriaMovimentacao(String nome) {
        this.nome = nome;
    }

    public Long getIdCategoriaMovimentacao() {
        return idCategoriaMovimentacao;
    }
    
    public void setIdCategoriaMovimentacao(Long idCategoriaMovimentacao) {
        this.idCategoriaMovimentacao = idCategoriaMovimentacao;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCategoriaMovimentacao == null) ? 0 : idCategoriaMovimentacao.hashCode());
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
        CategoriaMovimentacao other = (CategoriaMovimentacao) obj;
        if (idCategoriaMovimentacao == null) {
            if (other.idCategoriaMovimentacao != null)
                return false;
        } else if (!idCategoriaMovimentacao.equals(other.idCategoriaMovimentacao))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CategoriaMovimentacao [idCategoriaMovimentacao=" + idCategoriaMovimentacao + ", nome=" + nome + "]";
    }
}
