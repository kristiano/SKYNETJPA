/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.gov.to.secad.skynet.interfaces.DefaultQueries;
import br.gov.to.secad.skynet.model.Pessoa;
import br.gov.to.secad.skynet.util.GenericRepository;

/**
 *
 * @author Klimaco
 */
public class PessoaRepository extends GenericRepository<Pessoa> implements DefaultQueries<Pessoa, Long> {

    /**
     *
     * @param entityManager
     */
    public PessoaRepository(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Pessoa getById(Long id) {
        Query query = this.entityManager.createNamedQuery("Pessoa.getById");
        query.setParameter("id", id);
        return getSingleResult(query);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Pessoa> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("Pessoa.findAll");
        return query.getResultList();
    }
    
}
