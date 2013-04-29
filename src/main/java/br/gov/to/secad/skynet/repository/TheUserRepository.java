/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.repository;

import br.gov.to.secad.skynet.model.TheUser;
import br.gov.to.secad.skynet.util.GenericRepository;
import javax.persistence.EntityManager;

/**
 *
 * @author SKYNET
 */
public class TheUserRepository  extends GenericRepository<TheUser> {

    public TheUserRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
}
