package br.com.smr.SmartRecyclingManagement.controller.dto;

import br.com.smr.SmartRecyclingManagement.domain.ListaCompra;

import java.time.LocalDate;
import java.util.List;

public class ListaCompraDTO {

    private String nome;
    private String descricao;
    private LocalDate dataCadastro;
    private LocalDate dataCompra;
    private LocalDate dataAtualizacao;
    private String tipo;
    private List<ProdutoDTO> produtos;
    private Long listaCompraId;

    public ListaCompraDTO(String nome, String descricao, LocalDate dataCadastro, LocalDate dataCompra, LocalDate dataAtualizacao, String tipo, List<ProdutoDTO> produtos, Long listaCompraId) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.dataCompra = dataCompra;
        this.dataAtualizacao = dataAtualizacao;
        this.tipo = tipo;
        this.produtos = produtos;
        this.listaCompraId = listaCompraId;
    }

    public ListaCompraDTO() {
    }

    public ListaCompraDTO(ListaCompra listaCompra) {
        this.nome = listaCompra.getNome();
        this.descricao = listaCompra.getDescricao();
        this.dataCadastro = listaCompra.getDataCadastro();
        this.dataCompra = listaCompra.getDataCompra();
        this.dataAtualizacao = listaCompra.getDataAtualizacao();
        this.tipo = listaCompra.getTipo();
        this.listaCompraId = listaCompra.getId();

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

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public Long getListaCompraId() {
        return listaCompraId;
    }

    public void setListaCompraId(Long listaCompraId) {
        this.listaCompraId = listaCompraId;
    }

    @Override
    public String toString() {
        return "ListaCompraDTO{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataCompra=" + dataCompra +
                ", dataAtualizacao=" + dataAtualizacao +
                ", tipo='" + tipo + '\'' +
                ", produtos=" + produtos +
                ", listaCompraId=" + listaCompraId +
                '}';
    }
}
