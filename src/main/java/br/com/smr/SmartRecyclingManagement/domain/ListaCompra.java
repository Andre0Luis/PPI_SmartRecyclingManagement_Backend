package br.com.smr.SmartRecyclingManagement.domain;

import javax.persistence.*;

@Entity
public class ListaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private String dataCadastro;
    @Column
    private String dataCompra;
    @Column
    private String tipo;

    public ListaCompra() {
    }

    public ListaCompra(Long id, String nome, String descricao, String dataCadastro, String dataCompra, String tipo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.dataCompra = dataCompra;
        this.tipo = tipo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ListaCompra{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCadastro='" + dataCadastro + '\'' +
                ", dataCompra='" + dataCompra + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
