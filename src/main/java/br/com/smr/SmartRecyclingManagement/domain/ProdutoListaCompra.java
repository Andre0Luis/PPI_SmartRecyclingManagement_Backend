package br.com.smr.SmartRecyclingManagement.domain;

import javax.persistence.*;

@Entity
public class ProdutoListaCompra {
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
    @Column
    private Double pesoLiquido;
    @Column
    private Double pesoBruto;
    @Enumerated(EnumType.STRING)
    private TipoMaterial tipoMaterial;
    @Enumerated(EnumType.STRING)
    private TipoReciclagem tipoReciclagem;
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    @ManyToOne
    private ListaCompra listaCompra;

    public ProdutoListaCompra(Long id, String nome, String descricao, Double preco, Integer quantidade, String marca, String codBarras, Double peso, Double pesoEmbalagem, Double pesoLiquido, Double pesoBruto, TipoMaterial tipoMaterial, TipoReciclagem tipoReciclagem, CategoriaProduto categoria, ListaCompra listaCompra) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca = marca;
        this.codBarras = codBarras;
        this.peso = peso;
        this.pesoEmbalagem = pesoEmbalagem;
        this.pesoLiquido = pesoLiquido;
        this.pesoBruto = pesoBruto;
        this.tipoMaterial = tipoMaterial;
        this.tipoReciclagem = tipoReciclagem;
        this.categoria = categoria;
        this.listaCompra = listaCompra;
    }

    public ProdutoListaCompra() {
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

    public Double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(Double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public Double getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(Double pesoBruto) {
        this.pesoBruto = pesoBruto;
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

    public ListaCompra getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(ListaCompra listaCompra) {
        this.listaCompra = listaCompra;
    }

    @Override
    public String toString() {
        return "ProdutoListaCompra{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", marca='" + marca + '\'' +
                ", codBarras='" + codBarras + '\'' +
                ", peso=" + peso +
                ", pesoEmbalagem=" + pesoEmbalagem +
                ", pesoLiquido=" + pesoLiquido +
                ", pesoBruto=" + pesoBruto +
                ", tipoMaterial=" + tipoMaterial +
                ", tipoReciclagem=" + tipoReciclagem +
                ", categoria=" + categoria +
                ", listaCompra=" + listaCompra +
                '}';
    }
}
