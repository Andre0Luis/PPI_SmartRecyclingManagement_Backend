package br.com.smr.SmartRecyclingManagement.domain;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private Double preco;
    @Column
    private Integer quantidade;
    @Column
    private String marca;
    @Column
    private String codBarras;
    @Column
    private Double peso;
    @Column
    private Double pesoEmbalagem;
    @Enumerated(EnumType.STRING)
    private TipoMaterial tipoMaterial;
    @Enumerated(EnumType.STRING)
    private TipoReciclagem tipoReciclagem;
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Double preco, Integer quantidade, String marca, String codBarras, Double peso, Double pesoEmbalagem, TipoMaterial tipoMaterial, TipoReciclagem tipoReciclagem, CategoriaProduto categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca = marca;
        this.codBarras = codBarras;
        this.peso = peso;
        this.pesoEmbalagem = pesoEmbalagem;
        this.tipoMaterial = tipoMaterial;
        this.tipoReciclagem = tipoReciclagem;
        this.categoria = categoria;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPesoEmbalagem() {
        return pesoEmbalagem;
    }

    public void setPesoEmbalagem(Double pesoEmbalagem) {
        this.pesoEmbalagem = pesoEmbalagem;
    }

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public TipoReciclagem getTipoReciclagem() {
        return tipoReciclagem;
    }

    public void setTipoReciclagem(TipoReciclagem tipoReciclagem) {
        this.tipoReciclagem = tipoReciclagem;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", marca='" + marca + '\'' +
                ", codBarras='" + codBarras + '\'' +
                ", peso=" + peso +
                ", pesoEmbalagem=" + pesoEmbalagem +
                ", tipoMaterial=" + tipoMaterial +
                ", tipoReciclagem=" + tipoReciclagem +
                ", categoria=" + categoria +
                '}';
    }
}
