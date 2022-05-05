package br.com.smr.SmartRecyclingManagement.repository;

import br.com.smr.SmartRecyclingManagement.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
