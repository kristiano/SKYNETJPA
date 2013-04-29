/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.controller;

import br.gov.to.secad.skynet.model.TheUser;
import br.gov.to.secad.skynet.repository.TheUserRepository;
import br.gov.to.secad.skynet.stereotype.NamedSessionScoped;
import br.gov.to.secad.skynet.util.ApplicationUtilies;
import br.gov.to.secad.skynet.util.BasicBeanContent;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import org.primefaces.context.RequestContext;

/**
 *
 * @author SKYNET
 */
@NamedSessionScoped
public class TheUserController extends BasicBeanContent<TheUser, TheUserRepository> implements Serializable {
   private TheUser loggedTheUser;
    private String password;

    /**
     *
     */
    public TheUserController() {
        this.entity = new TheUser();
        this.loggedTheUser = null;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     */
    public void changePassword() {
        this.loggedTheUser.setPassword(this.password);
        this.repository = new TheUserRepository(ApplicationUtilies.catchEntityManager());
        this.repository.update(this.loggedTheUser);
        this.password = "";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterar senha", "Senha alterada com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", true);
    }

    /**
     *
     * @return
     */
    public TheUser getLoggedTheUser() {
        if (ApplicationUtilies.isLogged() && this.loggedTheUser == null) {
            setLoggedTheUser((TheUser) ApplicationUtilies.getAuthenticadedUser());
        }
        return this.loggedTheUser;
    }

    /**
     *
     * @param loggedTheUser
     */
    public void setLoggedTheUser(TheUser loggedTheUser) {
        this.loggedTheUser = loggedTheUser;
    }

    /**
     *
     */
    public void editarPerfil() {
        this.repository = new TheUserRepository(ApplicationUtilies.catchEntityManager());
        this.repository.update(this.loggedTheUser);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, loggedTheUser.getNome() + " : Perfil altualizado com sucesso", ""));
        this.entity = new TheUser();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    @Override
    public void insert() {
        
        this.repository = new TheUserRepository(ApplicationUtilies.catchEntityManager());
        this.entity.setDataCadastro(new Date());
        System.err.println("inferno"+this.entity.getNome());
        this.entity.setUsername(this.entity.getNome());
        this.getRepository().insert(this.entity);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro inserido com sucesso: ", entity.getNome()));
        this.entity = new TheUser();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    @Override
    public void update() {
        this.repository = new TheUserRepository(ApplicationUtilies.catchEntityManager());
        System.out.println(this.entity);
        this.loggedTheUser = this.entity;
        this.getRepository().update(this.loggedTheUser);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro atualizado com sucesso: ", loggedTheUser.getNome()));
        this.entity = new TheUser();
        this.listOfEntities.clear();
    }

    /**
     *
     */
    public void reset() {
        this.password = "";
    }
}
