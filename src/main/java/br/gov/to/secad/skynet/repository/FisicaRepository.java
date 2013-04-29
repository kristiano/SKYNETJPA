/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.gov.to.secad.skynet.interfaces.DefaultQueries;
import br.gov.to.secad.skynet.model.Fisica;
import br.gov.to.secad.skynet.util.GenericRepository;

/**
 *
 * @author Klimaco
 */
public class FisicaRepository extends GenericRepository<Fisica> implements DefaultQueries<Fisica, Long> {

    /**
     *
     * @param entityManager
     */
    public FisicaRepository(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Fisica getById(Long id) {
        Query query = this.entityManager.createNamedQuery("Fisica.getById");
        query.setParameter("id", id);
        return getSingleResult(query);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Fisica> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("Fisica.findAll");
        return query.getResultList();
    }
}
