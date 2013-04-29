/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;

import br.gov.to.secad.skynet.interfaces.DefaultQueries;
import br.gov.to.secad.skynet.model.Servidor;
import br.gov.to.secad.skynet.util.GenericRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SKYNET
 */
public class ServidorRepository  extends GenericRepository<Servidor> implements DefaultQueries<Servidor, Long> {

    public ServidorRepository(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Servidor getById(Long id) {
        Query query = this.entityManager.createNamedQuery("Servidor.getById");
        query.setParameter("id", id);
        return getSingleResult(query);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Servidor> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("Servidor.findAll");
        return query.getResultList();
    }
    
     public List<Servidor> getServidorProntuario(Long id) {
        Query query = this.entityManager.createQuery("SELECT s FROM servidor s  JOIN s.prontuario p WHERE p.id :=id");
        query.setParameter("id", id);
        return query.getResultList();
    }
    
}
