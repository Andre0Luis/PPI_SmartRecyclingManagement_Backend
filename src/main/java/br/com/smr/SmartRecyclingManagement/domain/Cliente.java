package br.com.smr.SmartRecyclingManagement.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String telefone;

    @JsonBackReference
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ListaCompra> listaCompra;


    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String telefone, List<ListaCompra> listaCompra) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.listaCompra = listaCompra;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<ListaCompra> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<ListaCompra> listaCompra) {
        this.listaCompra = listaCompra;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", listaCompra=" + listaCompra +
                '}';
    }
}
