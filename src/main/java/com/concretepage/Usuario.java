package com.concretepage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario implements Serializable{

    private Long idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Date dtNascimento;
    private Set<Conta> contas;
    
    public Usuario() { }

    public Usuario(String nome, String email, String senha, String telefone, Date dtNascimento) {
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
    }

    public Usuario(String nome, String email, Date dtNascimento) {
        this.nome = nome;
        this.email = email;
        this.dtNascimento = dtNascimento;
    }
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }
    
    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Set<Conta> getContas() {
        return contas;
    }
    
    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
        Usuario other = (Usuario) obj;
        if (idUsuario == null) {
            if (other.idUsuario != null)
                return false;
        } else if (!idUsuario.equals(other.idUsuario))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefone=" + telefone
                + ", dtNascimento=" + dtNascimento + "]";
    }
}
