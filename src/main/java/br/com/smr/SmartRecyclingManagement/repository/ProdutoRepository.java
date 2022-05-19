package br.com.smr.SmartRecyclingManagement.repository;

import br.com.smr.SmartRecyclingManagement.controller.dto.ProdutoDTO;
import br.com.smr.SmartRecyclingManagement.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByCodBarras(String codBarras);
}
