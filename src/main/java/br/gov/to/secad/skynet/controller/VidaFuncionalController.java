/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.controller;

import br.gov.to.secad.skynet.model.VidaFuncional;
import br.gov.to.secad.skynet.repository.VidaFuncionalRepository;
import br.gov.to.secad.skynet.stereotype.NamedSessionScoped;
import br.gov.to.secad.skynet.util.ApplicationUtilies;
import br.gov.to.secad.skynet.util.BasicBeanContent;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author SKYNET
 */
@NamedSessionScoped
public class VidaFuncionalController extends BasicBeanContent<VidaFuncional, VidaFuncionalRepository> implements Serializable {

    @Inject
    ProntuarioController prontuario;
    private VidaFuncional vidaFuncional;
    public VidaFuncionalController() {
             this.entity = new VidaFuncional();
        System.err.println("CONSTRUTOR--->"+entity);
    }

    @Override
    public void insert() {
        this.repository = new VidaFuncionalRepository(ApplicationUtilies.catchEntityManager());
        this.repository.insert(this.entity);
        // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "VidaFuncional inserida com sucesso ", ""));
        this.entity = new VidaFuncional();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    @Override
    public void remove() {
        this.repository = new VidaFuncionalRepository(ApplicationUtilies.catchEntityManager());
        this.repository.remove(this.entity);
        this.entity = new VidaFuncional();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    @Override
    public void update() {
        this.repository = new VidaFuncionalRepository(ApplicationUtilies.catchEntityManager());

        this.repository.update(this.entity);
        //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "VidaFuncional atualizada com sucesso ", ""));
        this.entity = new VidaFuncional();
        this.listOfEntities.clear();
    }

    public List<VidaFuncional> getItems() {
        System.err.println("PORQUE--->"+entity);
        this.repository = new VidaFuncionalRepository(ApplicationUtilies.catchEntityManager());
        listOfEntities = this.repository.getVidasProntuario(prontuario.getIdProntuario());
        return listOfEntities;
    }

   

    public ProntuarioController getProntuario() {
        return prontuario;
    }

    public void setProntuario(ProntuarioController prontuario) {
        this.prontuario = prontuario;
    }

    public VidaFuncional getVidaFuncional() {
        return vidaFuncional;
    }

    public void setVidaFuncional(VidaFuncional vidaFuncional) {
        this.vidaFuncional = vidaFuncional;
    }
    
}
