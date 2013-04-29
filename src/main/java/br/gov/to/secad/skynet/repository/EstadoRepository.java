/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;

import br.gov.to.secad.skynet.model.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.gov.to.secad.skynet.interfaces.DefaultQueries;

import br.gov.to.secad.skynet.util.GenericRepository;

/**
 *
 * @author Klimaco
 */
public class EstadoRepository extends GenericRepository<Estado> implements DefaultQueries<Estado, Long> {

    /**
     *
     * @param entityManager
     */
    public EstadoRepository(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Estado getById(Long id) {
        Query query = this.entityManager.createNamedQuery("Estado.getById");
        query.setParameter("id", id);
        return getSingleResult(query);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Estado> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("Estado.findAll");
        return query.getResultList();
    }
}
