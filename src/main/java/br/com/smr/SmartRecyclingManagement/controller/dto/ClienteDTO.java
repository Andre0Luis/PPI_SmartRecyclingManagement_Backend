package br.com.smr.SmartRecyclingManagement.controller.dto;

import br.com.smr.SmartRecyclingManagement.domain.Cliente;

import java.util.List;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private List<ListaCompraDTO> listaCompra;

    public ClienteDTO(Long id, String nome, String email, String telefone, List<ListaCompraDTO> listaCompra) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.listaCompra = listaCompra;
    }

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
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

    public List<ListaCompraDTO> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<ListaCompraDTO> listaCompra) {
        this.listaCompra = listaCompra;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", listaCompra=" + listaCompra +
                '}';
    }
}
