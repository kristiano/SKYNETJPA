/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.controller;

import br.gov.to.secad.skynet.model.Prontuario;
import br.gov.to.secad.skynet.repository.ProntuarioRepository;
import br.gov.to.secad.skynet.stereotype.NamedSessionScoped;
import br.gov.to.secad.skynet.util.ApplicationUtilies;
import br.gov.to.secad.skynet.util.BasicBeanContent;
import java.io.Serializable;

/**
 *
 * @author SKYNET
 */
@NamedSessionScoped
public class ProntuarioController extends  BasicBeanContent<Prontuario, ProntuarioRepository> implements Serializable {
    private Long idProntuario;
    private Prontuario inferno;
    public ProntuarioController() {
        this.entity = new Prontuario();
        inferno = new Prontuario();
        System.err.print("PRONTUARIO1-->"+inferno);
        System.err.print("PRONTUARIO2-->"+entity);
    }
    
    @Override
    public void insert() {
        this.repository = new ProntuarioRepository(ApplicationUtilies.catchEntityManager()); 
        this.repository.insert(this.entity);
       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Prontuario inserida com sucesso ", ""));
        this.entity = new Prontuario();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    @Override
    public void remove() {
        this.repository = new ProntuarioRepository(ApplicationUtilies.catchEntityManager());
        this.repository.remove(this.entity);
        this.entity = new Prontuario();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    @Override
    public void update() {
        this.repository = new ProntuarioRepository(ApplicationUtilies.catchEntityManager());         
        
        this.repository.update(this.entity);
     //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Prontuario atualizada com sucesso ", ""));
        this.entity = new Prontuario();
        this.listOfEntities.clear();
    }
    public void numeroo() {
        System.out.print("merda--->"+this.inferno.getNumero());
        this.repository = new ProntuarioRepository(ApplicationUtilies.catchEntityManager());
        this.entity = this.repository.getByIdNumero(this.inferno.getNumero());
        //this.setIdProntuario(this.entity.getId());
        System.out.print("idd-->"+this.getIdProntuario());
    }

    public Long getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(Long idProntuario) {
        this.idProntuario = idProntuario;
    }

    public Prontuario getInferno() {
        return inferno;
    }

    public void setInferno(Prontuario inferno) {
        this.inferno = inferno;
    }

    
}
