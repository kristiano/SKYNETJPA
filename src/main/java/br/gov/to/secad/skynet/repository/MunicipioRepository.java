/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.gov.to.secad.skynet.interfaces.DefaultQueries;
import br.gov.to.secad.skynet.model.Municipio;
import br.gov.to.secad.skynet.util.GenericRepository;

/**
 *
 * @author Klimaco
 */
public class MunicipioRepository extends GenericRepository<Municipio> implements DefaultQueries<Municipio, Long> {

    /**
     *
     * @param entityManager
     */
    public MunicipioRepository(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Municipio getById(Long id) {
        Query query = this.entityManager.createNamedQuery("Municipio.getById");
        query.setParameter("id", id);
        return getSingleResult(query);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Municipio> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("Municipio.findAll");
        return query.getResultList();
    }
}


