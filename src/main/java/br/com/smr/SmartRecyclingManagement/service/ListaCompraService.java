package br.com.smr.SmartRecyclingManagement.service;

import br.com.smr.SmartRecyclingManagement.controller.dto.ListaCompraDTO;
import br.com.smr.SmartRecyclingManagement.domain.Cliente;
import br.com.smr.SmartRecyclingManagement.domain.ListaCompra;
import br.com.smr.SmartRecyclingManagement.repository.ListaCompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListaCompraService {

    private final ListaCompraRepository listaCompraRepository;
    private final ProdutoService produtoService;
    private final ProdutoListaCompraService produtoListaCompraService;
    private final ClienteService clienteService;

    public ListaCompraService(ListaCompraRepository listaCompraRepository, ProdutoService produtoService, ProdutoListaCompraService produtoListaCompraService, ClienteService clienteService) {
        this.listaCompraRepository = listaCompraRepository;
        this.produtoService = produtoService;
        this.produtoListaCompraService = produtoListaCompraService;
        this.clienteService = clienteService;
    }

    public Optional<ListaCompra> save(ListaCompraDTO dto, String email){

        ListaCompra listaCompra = new ListaCompra();
        listaCompra.setNome(dto.getNome());
        listaCompra.setDescricao(dto.getDescricao());
        listaCompra.setDataCompra(dto.getDataCompra());
        listaCompra.setDataCadastro(dto.getDataCadastro());
        listaCompra.setTipo(dto.getTipo());

        //Busca no banco de dados o cliente vinculado a esse email
        Cliente clienteEmail = clienteService.findByEmail(email);

        //Define o id do cliente encontrado
        Cliente cliente = new Cliente();
        cliente.setId(clienteEmail.getId());

        //Adiciona o id do cliente a lista de compras
        listaCompra.setCliente(cliente);

        //Salva a lista de compras
        ListaCompra listaCompraSalva = listaCompraRepository.save(listaCompra);

        //Vai salvar todos os itens da lista de compras
        dto.getProdutos().forEach(produto -> {
            produto.setListaCompraId(listaCompraSalva.getId());
            produtoListaCompraService.save(produto);
        } );


        return listaCompraRepository.findById(listaCompra.getId());
    }

    public ListaCompra update(ListaCompraDTO dto, Long id){
        ListaCompra listaCompraUpdate = listaCompraRepository.getById(id);
        listaCompraUpdate.setNome(dto.getNome());
        listaCompraUpdate.setDescricao(dto.getDescricao());
        listaCompraUpdate.setDataCompra(dto.getDataCompra());
        listaCompraUpdate.setDataCadastro(dto.getDataCadastro());
        listaCompraUpdate.setTipo(dto.getTipo());
        return listaCompraRepository.save(listaCompraUpdate);
    }

    public List<ListaCompraDTO> findAllByClienteId(Long id){

        return listaCompraRepository.findAllByClienteId(id).stream().map(ListaCompraDTO::new).collect(Collectors.toList());
    }
    public Optional<ListaCompraDTO> findById(Long id){
        return listaCompraRepository.findById(id).map(ListaCompraDTO::new);
    }

    public List<ListaCompra> findAll(){
        return listaCompraRepository.findAll();
    }

    public void delete(Long id){
        listaCompraRepository.deleteById(id);
    }

}
