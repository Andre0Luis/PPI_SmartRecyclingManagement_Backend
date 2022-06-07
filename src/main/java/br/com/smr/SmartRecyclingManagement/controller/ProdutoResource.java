package br.com.smr.SmartRecyclingManagement.controller;

import br.com.smr.SmartRecyclingManagement.controller.dto.ConsumoMensalDTO;
import br.com.smr.SmartRecyclingManagement.controller.dto.ProdutoDTO;
import br.com.smr.SmartRecyclingManagement.domain.Produto;
import br.com.smr.SmartRecyclingManagement.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto")
public class ProdutoResource {

    public final ProdutoService produtoService;

    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @RequestMapping("/buscar")
    public ResponseEntity<Optional<Produto>> getProduto(@RequestParam(value = "id") Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @RequestMapping("/buscar-cod")
    public ResponseEntity<Optional<ProdutoDTO>> getProdutoCodBarras(@RequestParam(value = "cod") String cod) {
        Optional<ProdutoDTO> produto = produtoService.findByCodBarras(cod);
        return ResponseEntity.ok().body(produto);
    }
    @RequestMapping("/buscar-todos")
    public ResponseEntity<List<Produto>> getTodosProdutos() {
        List<Produto> produto = produtoService.findAll();
        return ResponseEntity.ok().body(produto);
    }

    @RequestMapping("/buscar-produto")
    public ResponseEntity<List<ProdutoDTO>> findProdutos(Pageable pageable,
                                                         @RequestParam(required = false, value = "nome") String nome,
                                                         @RequestParam(required = false, value = "marca") String marca,
                                                         @RequestParam(required = false, value = "codBarras") String codBarras) {
        Page<ProdutoDTO> produtos = produtoService.findAllCriteria(pageable, nome, marca, codBarras);
        List<ProdutoDTO> produtosList = produtos.getContent();
        return ResponseEntity.ok().body(produtosList);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoService.save(produtoDTO);
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody ProdutoDTO produtoDTO, @RequestParam(value = "id") Long id) {
        Produto produto = produtoService.update(produtoDTO, id);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarProduto(@RequestParam(value = "id") Long id) {
        produtoService.delete(id);
        return ResponseEntity.ok().body("produto: " + id + " deletado com sucesso!");
    }
}



