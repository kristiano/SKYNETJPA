/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;

import br.gov.to.secad.skynet.interfaces.DefaultQueries;
import br.gov.to.secad.skynet.model.Prontuario;
import br.gov.to.secad.skynet.util.GenericRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SKYNET
 */
public class ProntuarioRepository extends GenericRepository<Prontuario> implements DefaultQueries<Prontuario, Long> {
    public ProntuarioRepository(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Prontuario getById(Long id) {
        Query query = this.entityManager.createNamedQuery("Prontuario.getById");
        query.setParameter("id", id);
        return getSingleResult(query);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Prontuario> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("Prontuario.findAll");
        return query.getResultList();
    }
    
    public Prontuario getByIdNumero(String numero) {
        Query query = this.entityManager.createNamedQuery("Prontuario.getByIdNumero");
        query.setParameter("numero", numero);
        return getSingleResult(query);
    }
    
}
