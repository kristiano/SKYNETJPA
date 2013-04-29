/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.controller;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import br.gov.to.secad.skynet.model.Usuario;
import br.gov.to.secad.skynet.repository.UsuarioRepository;
import br.gov.to.secad.skynet.util.ApplicationUtilies;
import br.gov.to.secad.skynet.util.BasicBeanContent;

/**
 *
 * @author Klimaco
 */
@Named("UsuarioController")
@SessionScoped
public class UsuarioController extends BasicBeanContent<Usuario, UsuarioRepository> implements Serializable {

    private Usuario loggedUsuario;
    private String password = "";
    private String confirmarPassword = "";

    /**
     *
     */
    public UsuarioController() {
        this.entity = new Usuario();
        this.loggedUsuario = null;
    }

    /**
     *
     */
    @Override
    public void insert() {
        this.repository = new UsuarioRepository(ApplicationUtilies.catchEntityManager());
        this.repository.insert(this.entity);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario criado com sucesso: ", entity.getNome()));
        this.entity = new Usuario();
    }

    /**
     *
     */
    @Override
    public void remove() {
        this.repository = new UsuarioRepository(ApplicationUtilies.catchEntityManager());
        this.repository.remove(this.entity);
        this.entity = new Usuario();
    }

    /**
     *
     */
    @Override
    public void update() {
        this.repository = new UsuarioRepository(ApplicationUtilies.catchEntityManager());
        this.repository.update(this.entity);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario atualizado com sucesso: ", entity.getNome()));
        this.entity = new Usuario();
    }

    /**
     *
     * @return
     */
    public Usuario getLoggedUsuario() {
        if (ApplicationUtilies.isLogged() && this.loggedUsuario == null) {
            setLoggedUsuario((Usuario) ApplicationUtilies.getAuthenticadedUser());
        }
        return this.loggedUsuario;
    }

    /**
     *
     * @param loggedUsuario
     */
    public void setLoggedUsuario(Usuario loggedUsuario) {
        this.loggedUsuario = loggedUsuario;
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
     * @return
     */
    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    /**
     *
     * @param confirmarPassword
     */
    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

    /**
     *
     * @return
     * @throws InterruptedException
     */
    public String changePassword() throws InterruptedException {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage();
        facesMessage.setSeverity(facesMessage.SEVERITY_ERROR);
        if (this.password == null ? this.confirmarPassword != null : !this.password.equals(this.confirmarPassword)) {

            facesMessage.setDetail("the passwords does not match");
            context.addMessage("Erro", facesMessage);

            return null;
        } else {
            if (this.password.length() < 6) {
                facesMessage.setDetail("at least 6 characters");
                context.addMessage("Error", facesMessage);
                return null;
            } else {

                this.loggedUsuario.setPassword(this.password);
                this.repository = new UsuarioRepository(ApplicationUtilies.catchEntityManager());
                this.repository.update(this.loggedUsuario);
                this.password = "";
                this.confirmarPassword = "";

                return "pretty:sucesso";
            }
        }


    }

    /**
     *
     * @return
     */
    public String goToLogin() {
        return "pretty:login";
    }

    /**
     *
     */
    public void idleListener() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Sua sessão será fechada", "Você está ausente a 15 min"));
        //invalidate session
    }

    /**
     *
     */
    public void activeListener() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Seja bem-vindo de volta", "Demorou ein?!"));
    }
    
    /**
     *
     * @return
     */
    public Usuario getUsuarioLogado () {
        return (Usuario) ApplicationUtilies.getUsuarioLogado();
    }
}
