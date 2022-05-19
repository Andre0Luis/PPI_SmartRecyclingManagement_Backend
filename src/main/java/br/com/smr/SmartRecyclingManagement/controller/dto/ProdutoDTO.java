package br.com.smr.SmartRecyclingManagement.controller.dto;

import br.com.smr.SmartRecyclingManagement.domain.CategoriaProduto;
import br.com.smr.SmartRecyclingManagement.domain.Produto;
import br.com.smr.SmartRecyclingManagement.domain.TipoMaterial;
import br.com.smr.SmartRecyclingManagement.domain.TipoReciclagem;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private String marca;
    private String codBarras;
    private Double peso;
    private Double pesoEmbalagem;
    private Double pesoLiquido;
    private Double pesoBruto;
    private TipoMaterial tipoMaterial;
    private TipoReciclagem tipoReciclagem;
    private CategoriaProduto categoria;
    private Long ListaCompraId;

    public ProdutoDTO(Long id, String nome, String descricao, Double preco, Integer quantidade, String marca, String codBarras, Double peso, Double pesoEmbalagem, Double pesoLiquido, Double pesoBruto, TipoMaterial tipoMaterial, TipoReciclagem tipoReciclagem, CategoriaProduto categoria, Long listaCompraId) {
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
        this.ListaCompraId = listaCompraId;
    }

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
        this.marca = produto.getMarca();
        this.codBarras = produto.getCodBarras();
        this.peso = produto.getPeso();
        this.pesoEmbalagem = produto.getPesoEmbalagem();
        this.pesoLiquido = produto.getPesoLiquido();
        this.pesoBruto = produto.getPesoBruto();
        this.tipoMaterial = produto.getTipoMaterial();
        this.tipoReciclagem = produto.getTipoReciclagem();
        this.categoria = produto.getCategoria();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoDTO(ProdutoDTO produtoDTO) {
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

    public Long getListaCompraId() {
        return ListaCompraId;
    }

    public void setListaCompraId(Long listaCompraId) {
        ListaCompraId = listaCompraId;
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" +
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
                ", ListaCompraId=" + ListaCompraId +
                '}';
    }
}
