package br.com.smr.SmartRecyclingManagement.service;

import br.com.smr.SmartRecyclingManagement.controller.dto.ProdutoDTO;
import br.com.smr.SmartRecyclingManagement.domain.CriteriaProdutoRepository;
import br.com.smr.SmartRecyclingManagement.domain.Produto;
import br.com.smr.SmartRecyclingManagement.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    public final ProdutoRepository produtoRepository;

    public final CriteriaProdutoRepository criteriaProdutoRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CriteriaProdutoRepository criteriaProdutoRepository) {
        this.produtoRepository = produtoRepository;
        this.criteriaProdutoRepository = criteriaProdutoRepository;
    }

    public Produto save(ProdutoDTO produto){

        Produto produtoSalvo = new Produto();
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
        produtoSalvo.setPesoEmbalagem(pesoEmbalagem(produto));

        return produtoRepository.save(produtoSalvo);
    }

    public double pesoEmbalagem(ProdutoDTO produto){
        double pesoEmbalagem = (produto.getPesoBruto() - produto.getPesoLiquido());
    	return pesoEmbalagem;
    }

    public Produto update(ProdutoDTO produto, Long id){
        Produto produtoSalvo = produtoRepository.getById(id);
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

        return produtoRepository.save(produtoSalvo);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id){
        return produtoRepository.findById(id);
    }

    public Optional<ProdutoDTO> findByCodBarras(String codBarras){
        return produtoRepository.findByCodBarras(codBarras).map(ProdutoDTO::new);
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }

    public Page<ProdutoDTO> findAllCriteria(Pageable pageable, String nome, String marca, String codBarras){
        return criteriaProdutoRepository.findAllProdutos(pageable, nome, marca, codBarras).map(ProdutoDTO::new);
    }
}
