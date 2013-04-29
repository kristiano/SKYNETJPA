/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.gov.to.secad.skynet.interfaces.DefaultQueries;
import br.gov.to.secad.skynet.model.PasswordRecovery;
import br.gov.to.secad.skynet.util.GenericRepository;

/**
 *
 * @author marceloclaudios
 */
public class PasswordRecoveryRepository extends 
        GenericRepository<PasswordRecovery> implements
        DefaultQueries<PasswordRecovery,String> {

    /**
     *
     * @param entityManager
     */
    public PasswordRecoveryRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Override
    public PasswordRecovery getById(String id) {
        Query query = this.entityManager.createNamedQuery("PasswordRecovery.getById");
        query.setParameter("id", id);
        PasswordRecovery result = getSingleResult(query);
        return result;
    }

    /**
     *
     * @return
     */
    @Override
    public List<PasswordRecovery> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("PasswordRecovery.findAll");
        return query.getResultList();
    }
    
    /**
     *
     * @param id
     */
    public void removeByID(Long id){
        String hql = "delete from PasswordRecovery where usuario_id = :id";
        Query query = this.entityManager.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
