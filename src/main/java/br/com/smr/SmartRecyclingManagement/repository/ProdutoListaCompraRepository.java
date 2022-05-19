package br.com.smr.SmartRecyclingManagement.repository;

import br.com.smr.SmartRecyclingManagement.domain.Produto;
import br.com.smr.SmartRecyclingManagement.domain.ProdutoListaCompra;
import br.com.smr.SmartRecyclingManagement.service.ProdutoListaCompraService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoListaCompraRepository extends JpaRepository<ProdutoListaCompra, Long> {

    Optional<ProdutoListaCompra> findByCodBarras(String codBarras);
}
