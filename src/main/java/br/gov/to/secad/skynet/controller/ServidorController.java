/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.controller;

import br.gov.to.secad.skynet.model.Servidor;
import br.gov.to.secad.skynet.repository.ServidorRepository;
import br.gov.to.secad.skynet.stereotype.NamedViewScoped;
import br.gov.to.secad.skynet.util.ApplicationUtilies;
import br.gov.to.secad.skynet.util.BasicBeanContent;
import java.io.Serializable;

/**
 *
 * @author SKYNET
 */
@NamedViewScoped
public class ServidorController extends  BasicBeanContent<Servidor, ServidorRepository> implements Serializable {

    public ServidorController() {
        this.entity = new Servidor();
    }
    
    @Override
    public void insert() {
        this.repository = new ServidorRepository(ApplicationUtilies.catchEntityManager()); 
        this.repository.insert(this.entity);
       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Servidor inserida com sucesso ", ""));
        this.entity = new Servidor();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    @Override
    public void remove() {
        this.repository = new ServidorRepository(ApplicationUtilies.catchEntityManager());
        this.repository.remove(this.entity);
        this.entity = new Servidor();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    @Override
    public void update() {
        this.repository = new ServidorRepository(ApplicationUtilies.catchEntityManager());         
        
        this.repository.update(this.entity);
     //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Servidor atualizada com sucesso ", ""));
        this.entity = new Servidor();
        this.listOfEntities.clear();
    }

}
