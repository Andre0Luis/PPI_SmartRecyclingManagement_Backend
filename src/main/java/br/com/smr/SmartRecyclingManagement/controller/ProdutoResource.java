package br.com.smr.SmartRecyclingManagement.controller;

import br.com.smr.SmartRecyclingManagement.controller.dto.ProdutoDTO;
import br.com.smr.SmartRecyclingManagement.domain.Produto;
import br.com.smr.SmartRecyclingManagement.service.ProdutoService;
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
    @RequestMapping("/buscar-tudo")
    public ResponseEntity<List<Produto>> getTodosProdutos() {
        List<Produto> produto = produtoService.findAll();
        return ResponseEntity.ok().body(produto);
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


}
