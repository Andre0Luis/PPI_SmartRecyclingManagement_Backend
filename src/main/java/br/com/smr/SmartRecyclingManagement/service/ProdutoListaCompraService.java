package br.com.smr.SmartRecyclingManagement.service;

import br.com.smr.SmartRecyclingManagement.controller.dto.ProdutoDTO;
import br.com.smr.SmartRecyclingManagement.domain.ListaCompra;
import br.com.smr.SmartRecyclingManagement.domain.Produto;
import br.com.smr.SmartRecyclingManagement.domain.ProdutoListaCompra;
import br.com.smr.SmartRecyclingManagement.repository.ProdutoListaCompraRepository;
import br.com.smr.SmartRecyclingManagement.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoListaCompraService {

    public final ProdutoListaCompraRepository produtoListaCompraRepository;
    public final ProdutoRepository produtoRepository;

    public ProdutoListaCompraService(ProdutoListaCompraRepository produtoListaCompraRepository, ProdutoRepository produtoRepository) {
        this.produtoListaCompraRepository = produtoListaCompraRepository;
        this.produtoRepository = produtoRepository;
    }



    public ProdutoListaCompra save(ProdutoDTO produto){

        ProdutoListaCompra produtoSalvo = new ProdutoListaCompra();
        produtoSalvo.setPreco(produto.getPreco());
        produtoSalvo.setNome(produto.getNome());
        produtoSalvo.setMarca(produto.getMarca());
        produtoSalvo.setQuantidade(produto.getQuantidade());
        produtoSalvo.setCodBarras(produto.getCodBarras());
        produtoSalvo.setPesoBruto(produto.getPesoBruto());
        produtoSalvo.setPesoLiquido(produto.getPesoLiquido());
        produtoSalvo.setPesoEmbalagem(produto.getPesoEmbalagem());
        produtoSalvo.setDescricao(produto.getDescricao());
        produtoSalvo.setQuantidade(produto.getQuantidade());
        produtoSalvo.setCategoria(produto.getCategoria());
        produtoSalvo.setTipoMaterial(produto.getTipoMaterial());
        produtoSalvo.setTipoReciclagem(produto.getTipoReciclagem());

        ListaCompra listaCompra = new ListaCompra();
        listaCompra.setId(produto.getListaCompraId());
        produtoSalvo.setListaCompra(listaCompra);

        return produtoListaCompraRepository.save(produtoSalvo);
    }

    public ProdutoListaCompra update(ProdutoDTO produto, Long id){
        ProdutoListaCompra produtoSalvo = produtoListaCompraRepository.getById(id);
        produtoSalvo.setPreco(produto.getPreco());
        produtoSalvo.setNome(produto.getNome());
        produtoSalvo.setMarca(produto.getMarca());
        produtoSalvo.setQuantidade(produto.getQuantidade());
        produtoSalvo.setCodBarras(produto.getCodBarras());
        produtoSalvo.setPesoBruto(produto.getPesoBruto());
        produtoSalvo.setPesoLiquido(produto.getPesoLiquido());
        produtoSalvo.setPesoEmbalagem(produto.getPesoEmbalagem());
        produtoSalvo.setDescricao(produto.getDescricao());
        produtoSalvo.setQuantidade(produto.getQuantidade());
        produtoSalvo.setCategoria(produto.getCategoria());
        produtoSalvo.setTipoMaterial(produto.getTipoMaterial());
        produtoSalvo.setTipoReciclagem(produto.getTipoReciclagem());

        return produtoListaCompraRepository.save(produtoSalvo);
    }

    public List<ProdutoListaCompra> findAll(){
        return produtoListaCompraRepository.findAll();
    }

    public List<ProdutoDTO> findAllByListaCompraId(Long id){
        return produtoListaCompraRepository.findAllByListaCompraId(id).stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }

    public Optional<ProdutoListaCompra> findById(Long id){
        return produtoListaCompraRepository.findById(id);
    }

    public Optional<ProdutoDTO> findByCodBarras(String codBarras){
        return produtoRepository.findByCodBarras(codBarras).map(ProdutoDTO::new);
    }

    public void delete(Long id){
        produtoListaCompraRepository.deleteById(id);
    }

}
