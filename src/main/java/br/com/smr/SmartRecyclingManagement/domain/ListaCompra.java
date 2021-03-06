package br.com.smr.SmartRecyclingManagement.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    @CreationTimestamp
    private LocalDate dataCadastro;
    @Column
    private LocalDate dataCompra;
    @Column
    @UpdateTimestamp
    private LocalDate dataAtualizacao;
    @Column
    private String tipo;

    @ManyToOne
    private Cliente cliente;

    @JsonBackReference
    @OneToMany(mappedBy = "listaCompra", cascade = CascadeType.ALL)
    private List<ProdutoListaCompra> produtos;

    public ListaCompra(Long id, String nome, String descricao, LocalDate dataCadastro, LocalDate dataCompra, LocalDate dataAtualizacao, String tipo, Cliente cliente, List<ProdutoListaCompra> produtos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.dataCompra = dataCompra;
        this.dataAtualizacao = dataAtualizacao;
        this.tipo = tipo;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public ListaCompra() {
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<ProdutoListaCompra> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoListaCompra> produtos) {
        this.produtos = produtos;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ListaCompra{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataCompra=" + dataCompra +
                ", dataAtualizacao=" + dataAtualizacao +
                ", tipo='" + tipo + '\'' +
                ", cliente=" + cliente +
                ", produtos=" + produtos +
                '}';
    }
}
