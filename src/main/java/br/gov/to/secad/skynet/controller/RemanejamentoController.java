/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.controller;

import br.gov.to.secad.skynet.model.Remanejamento;
import br.gov.to.secad.skynet.repository.RemanejamentoRepository;
import br.gov.to.secad.skynet.stereotype.NamedSessionScoped;
import br.gov.to.secad.skynet.util.ApplicationUtilies;
import br.gov.to.secad.skynet.util.BasicBeanContent;
import java.io.Serializable;

/**
 *
 * @author SKYNET
 */
@NamedSessionScoped
public class RemanejamentoController extends BasicBeanContent<Remanejamento, RemanejamentoRepository> implements Serializable {
    public RemanejamentoController() {
        this.entity = new Remanejamento();
    }

    @Override
    public void insert() {
        this.repository = new RemanejamentoRepository(ApplicationUtilies.catchEntityManager());
        this.repository.insert(this.entity);
        // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Remanejamento inserida com sucesso ", ""));
        this.entity = new Remanejamento();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    @Override
    public void remove() {
        this.repository = new RemanejamentoRepository(ApplicationUtilies.catchEntityManager());
        this.repository.remove(this.entity);
        this.entity = new Remanejamento();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    @Override
    public void update() {
        this.repository = new RemanejamentoRepository(ApplicationUtilies.catchEntityManager());

        this.repository.update(this.entity);
        //   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Remanejamento atualizada com sucesso ", ""));
        this.entity = new Remanejamento();
        this.listOfEntities.clear();
    }
}
