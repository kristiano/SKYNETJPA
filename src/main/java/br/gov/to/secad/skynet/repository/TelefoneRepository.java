/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.gov.to.secad.skynet.interfaces.DefaultQueries;
import br.gov.to.secad.skynet.model.Telefone;
import br.gov.to.secad.skynet.util.GenericRepository;

/**
 *
 * @author Klimaco
 */
public class TelefoneRepository extends GenericRepository<Telefone> implements DefaultQueries<Telefone, Long> {

    /**
     *
     * @param entityManager
     */
    public TelefoneRepository(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Telefone getById(Long id) {
        Query query = this.entityManager.createNamedQuery("Telefone.getById");
        query.setParameter("id", id);
        return getSingleResult(query);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Telefone> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("Telefone.findAll");
        return query.getResultList();
    }
}


