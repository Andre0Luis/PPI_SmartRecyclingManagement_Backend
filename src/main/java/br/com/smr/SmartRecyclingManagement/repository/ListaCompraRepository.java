package br.com.smr.SmartRecyclingManagement.repository;

import br.com.smr.SmartRecyclingManagement.domain.ListaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaCompraRepository extends JpaRepository<ListaCompra, Long> {
    ListaCompra findByClienteId(Long id);

    List<ListaCompra> findAllByClienteId(Long id);

}
