package br.com.smr.SmartRecyclingManagement.controller;

import br.com.smr.SmartRecyclingManagement.controller.dto.ClienteDTO;
import br.com.smr.SmartRecyclingManagement.controller.dto.ListaCompraDTO;
import br.com.smr.SmartRecyclingManagement.domain.Cliente;
import br.com.smr.SmartRecyclingManagement.service.ClienteService;
import br.com.smr.SmartRecyclingManagement.service.ListaCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

    private final ClienteService clienteService;
    private ListaCompraService listaCompraService;
    public ClienteResource(ClienteService clienteService, ListaCompraService listaCompraService) {
        this.clienteService = clienteService;
        this.listaCompraService = listaCompraService;
    }
    @RequestMapping("/buscar")
    public ResponseEntity<Optional<ClienteDTO>> buscarCliente(@RequestParam(value = "id") Long id){
        Optional<ClienteDTO> cliente = clienteService.findById(id);

        List<ListaCompraDTO> listaCompra = listaCompraService.findAllByClienteId(cliente.get().getId());
        cliente.get().setListaCompra(listaCompra);

        return ResponseEntity.ok().body(cliente);
    }

    @RequestMapping("buscar-todos")
    public ResponseEntity<List<Cliente>> buscarTodos(){
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO cliente){
        Cliente clienteSalvo = clienteService.save(cliente);
        return ResponseEntity.ok().body(clienteSalvo);
    }

    @PostMapping("/atualizar")
    public ResponseEntity<Cliente> atualizar(@RequestBody ClienteDTO cliente, @RequestParam(value = "id") Long id){
        Cliente clienteAtualizado = clienteService.update(cliente, id);
        return ResponseEntity.ok().body(clienteAtualizado);
    }

    @RequestMapping("/excluir")
    public ResponseEntity<Void> excluir(@RequestParam(value = "id") Long id){
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }
}


