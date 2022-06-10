package br.com.smr.SmartRecyclingManagement.controller;

import br.com.smr.SmartRecyclingManagement.controller.dto.ConsumoMensalDTO;
import br.com.smr.SmartRecyclingManagement.controller.dto.ConsumoMensalPesoDTO;
import br.com.smr.SmartRecyclingManagement.controller.dto.ListaCompraDTO;
import br.com.smr.SmartRecyclingManagement.controller.dto.ProdutoDTO;
import br.com.smr.SmartRecyclingManagement.domain.ListaCompra;
import br.com.smr.SmartRecyclingManagement.service.ListaCompraService;
import br.com.smr.SmartRecyclingManagement.service.ProdutoListaCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/listaCompra")
public class ListaCompraResource {

    private final ListaCompraService listaCompraService;
    private final ProdutoListaCompraService produtoService;
    public ListaCompraResource(ListaCompraService listaCompraService, ProdutoListaCompraService produtoService) {
        this.listaCompraService = listaCompraService;
        this.produtoService = produtoService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Optional<ListaCompra>> salvarProduto(@RequestBody ListaCompraDTO dto) {
        //Essa informação vira da autenticação com o token
        String email = "aluis283@gmail.com";
        System.out.println("Produtos" + dto.getProdutosId());
        Optional<ListaCompra> listaCompra = listaCompraService.save(dto, email);

        return ResponseEntity.ok().body(listaCompra);
    }
    @PutMapping("/atualizar")
    public ResponseEntity<ListaCompra> atualizarProduto(@RequestBody ListaCompraDTO dto, @RequestParam(value = "id") Long id) {
        ListaCompra listaCompra = listaCompraService.update(dto, id);
        return ResponseEntity.ok().body(listaCompra);
    }

    @RequestMapping(value = "/busca-detalhada", method = RequestMethod.GET)
    public ResponseEntity<Optional<ListaCompraDTO>> getListaDetalhada(@RequestParam(value = "id") Long id) {
        Optional<ListaCompraDTO> listaCompra = listaCompraService.findById(id);

        List<ProdutoDTO> produtoDTO = produtoService.findAllByListaCompraId(id);
        listaCompra.get().setProdutos(produtoDTO);
        return ResponseEntity.ok().body(listaCompra);
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    public ResponseEntity<Optional<ListaCompraDTO>> getLista(@RequestParam(value = "id") Long id) {
        Optional<ListaCompraDTO> listaCompra = listaCompraService.findById(id);

        return ResponseEntity.ok().body(listaCompra);
    }


    @RequestMapping(value = "/buscar-todos", method = RequestMethod.GET)
    public ResponseEntity<List<ListaCompra>> getTodosProdutos() {
        List<ListaCompra> listaCompras = listaCompraService.findAll();
        return ResponseEntity.ok().body(listaCompras);
    }

    @RequestMapping(value = "/consumo-mensal/{clienteId}", method = RequestMethod.GET)
    public ResponseEntity<ConsumoMensalDTO> getConsumoMensal(@PathVariable Long clienteId) {

        ConsumoMensalDTO consumo = listaCompraService.findConsumoMensal(clienteId);

        return ResponseEntity.ok().body(consumo);
    }
    @RequestMapping(value = "/consumo-mensal-peso/{clienteId}", method = RequestMethod.GET)
    public ResponseEntity<ConsumoMensalPesoDTO> getConsumoMensalPeso(@PathVariable Long clienteId) {

        ConsumoMensalPesoDTO consumo = listaCompraService.findConsumoMensalPeso(clienteId);

        return ResponseEntity.ok().body(consumo);
    }

    @DeleteMapping("/remover")
    public ResponseEntity<String> removerProduto(@RequestParam(value = "id") Long id) {
        listaCompraService.delete(id);
        return ResponseEntity.ok().body("Produto removido com sucesso");
    }

}
