package br.com.smr.SmartRecyclingManagement.repository;

import br.com.smr.SmartRecyclingManagement.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CriteriaProdutoRepository {

    @Autowired
    private EntityManager em;

    public Page<Produto> findAllProdutos(Pageable pageable, String nome, String marca, String codBarras){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
        Root<Produto> produto = cq.from(Produto.class);
        List<Predicate> predicates = new ArrayList<>();

        if (nome != null) {
            Predicate nomePredicate = cb.like(produto.get("nome"), "%" + nome + "%");
            predicates.add(nomePredicate);
        }

        if (marca != null) {
            Predicate marcaPredicate = cb.like(produto.get("marca"), "%" + marca + "%");
            predicates.add(marcaPredicate);
        }

        if (codBarras != null) {
            Predicate codBarrasPredicate = cb.like(produto.get("codBarras"), "%" + codBarras + "%");
            predicates.add(codBarrasPredicate);
        }

        Predicate[] predicatesArray = new Predicate[predicates.size()];
        predicates.toArray(predicatesArray);

        cq.where(predicatesArray);

        List<Produto> result = em.createQuery(cq)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize()).getResultList();

        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Produto> countRoot = countQuery.from(Produto.class);
        countQuery.select(cb.count(countRoot)).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        Long total = em.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(result, pageable, total);
    }


}
