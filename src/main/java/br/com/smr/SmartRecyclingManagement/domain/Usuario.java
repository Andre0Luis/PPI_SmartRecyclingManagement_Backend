package br.com.smr.SmartRecyclingManagement.domain;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private Boolean ativacao;

    public Usuario() {
    }

    public Usuario(Long id, String email, String senha, Boolean ativacao) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.ativacao = ativacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getAtivacao() {
        return ativacao;
    }

    public void setAtivacao(Boolean ativacao) {
        this.ativacao = ativacao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", ativacao=" + ativacao +
                '}';
    }
}
