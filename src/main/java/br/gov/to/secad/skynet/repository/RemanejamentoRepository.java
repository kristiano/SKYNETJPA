/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;

import br.gov.to.secad.skynet.interfaces.DefaultQueries;
import br.gov.to.secad.skynet.model.Remanejamento;
import br.gov.to.secad.skynet.util.GenericRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SKYNET
 */
public class RemanejamentoRepository extends GenericRepository<Remanejamento> implements DefaultQueries<Remanejamento, Long> {
     
    public RemanejamentoRepository(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Remanejamento getById(Long id) {
        Query query = this.entityManager.createNamedQuery("Remanejamento.getById");
        query.setParameter("id", id);
        return getSingleResult(query);
    }
     @Override
    public List<Remanejamento> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("Remanejamento.findAll");
        return query.getResultList();
    }
}
