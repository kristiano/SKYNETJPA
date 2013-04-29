/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.gov.to.secad.skynet.interfaces.DefaultQueries;
import br.gov.to.secad.skynet.model.Endereco;
import br.gov.to.secad.skynet.util.GenericRepository;

/**
 *
 * @author Klimaco
 */
public class EnderecoRepository extends GenericRepository<Endereco> implements DefaultQueries<Endereco, Long> {

    /**
     *
     * @param entityManager
     */
    public EnderecoRepository(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Endereco getById(Long id) {
        Query query = this.entityManager.createNamedQuery("Endereco.getById");
        query.setParameter("id", id);
        return getSingleResult(query);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Endereco> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("Endereco.findAll");
        return query.getResultList();
    }
}
