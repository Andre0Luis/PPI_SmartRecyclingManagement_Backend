package br.com.smr.SmartRecyclingManagement.service;

import br.com.smr.SmartRecyclingManagement.controller.dto.ClienteDTO;
import br.com.smr.SmartRecyclingManagement.domain.Cliente;
import br.com.smr.SmartRecyclingManagement.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente save(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        return clienteRepository.save(cliente);
    }

    public Cliente update(ClienteDTO dto, Long id){
        Cliente cliente = clienteRepository.getById(id);
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        return clienteRepository.save(cliente);
    }

    public Optional<ClienteDTO> findById(Long id){

        return clienteRepository.findById(id).map(ClienteDTO::new);
    }

    public Cliente findByEmail(String email){
        return clienteRepository.findByEmail(email);
    }
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }
    public void delete(Long id){
        clienteRepository.deleteById(id);
    }
}
