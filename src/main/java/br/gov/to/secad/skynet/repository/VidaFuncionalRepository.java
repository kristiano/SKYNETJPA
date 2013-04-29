/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;

import br.gov.to.secad.skynet.interfaces.DefaultQueries;
import br.gov.to.secad.skynet.model.VidaFuncional;
import br.gov.to.secad.skynet.util.GenericRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SKYNET
 */
public class VidaFuncionalRepository  extends GenericRepository<VidaFuncional> implements DefaultQueries<VidaFuncional, Long> {

    public VidaFuncionalRepository(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public VidaFuncional getById(Long id) {
        Query query = this.entityManager.createNamedQuery("VidaFuncional.getById");
        query.setParameter("id", id);
        return getSingleResult(query);
    }

    /**
     *
     * @return
     */
    @Override
    public List<VidaFuncional> getListOfElements() {
        Query query = this.entityManager.createNamedQuery("VidaFuncional.findAll");
        return query.getResultList();
    }
    public List<VidaFuncional> getListOfElementsByServidor (Long id) {
        Query query = this.entityManager.createNamedQuery("VidaFuncional.getByServidores");
        query.setParameter("id", id);
        return query.getResultList();
    }
    public List<VidaFuncional> getVidaFuncionalsDefendidas(String mat) {
        Query query = this.entityManager.createQuery("SELECT a FROM VidaFuncional a WHERE a.matricula = :matricula ");
        query.setParameter("matricula", mat);
        return query.getResultList();
    }
    public List<VidaFuncional> getVidasProntuario(Long id) {
        Query query = this.entityManager.createQuery("SELECT a FROM VidaFuncional a JOIN a.prontuario p WHERE p.id =:id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
