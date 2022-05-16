package br.com.smr.SmartRecyclingManagement.service;

import br.com.smr.SmartRecyclingManagement.domain.ListaCompra;
import br.com.smr.SmartRecyclingManagement.repository.ListaCompraRepository;
import org.springframework.stereotype.Service;

@Service
public class ListaCompraService {

    private final ListaCompraRepository listaCompraRepository;

    public ListaCompraService(ListaCompraRepository listaCompraRepository) {
        this.listaCompraRepository = listaCompraRepository;
    }

    public ListaCompra save(ListaCompra dto){

        ListaCompra listaCompra = new ListaCompra();
        listaCompra.setNome(dto.getNome());
        listaCompra.setDescricao(dto.getDescricao());
        listaCompra.setDataCompra(dto.getDataCompra());
        listaCompra.setDataCadastro(dto.getDataCadastro());

        return listaCompraRepository.save(listaCompra);
    }

    public ListaCompra update(ListaCompra listaCompra){
        return listaCompraRepository.save(listaCompra);
    }

    public ListaCompra findById(Long id){
        return listaCompraRepository.findById(id).orElse(null);
    }

    public void delete(ListaCompra listaCompra){
        listaCompraRepository.delete(listaCompra);
    }
}
