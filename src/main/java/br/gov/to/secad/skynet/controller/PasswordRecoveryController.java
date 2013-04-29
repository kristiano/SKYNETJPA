/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.controller;


import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.commons.mail.EmailException;
import br.gov.to.secad.skynet.model.EmailBuilder;
import br.gov.to.secad.skynet.model.PasswordRecovery;
import br.gov.to.secad.skynet.model.Usuario;
import br.gov.to.secad.skynet.repository.PasswordRecoveryRepository;
import br.gov.to.secad.skynet.repository.UsuarioRepository;
import br.gov.to.secad.skynet.util.ApplicationUtilies;
import br.gov.to.secad.skynet.util.BasicBeanContent;

/**
 *
 * @author marceloclaudios
 */
@URLMapping(id = "passRecovery", pattern = "/reset-password/#{PasswordRecoveryBean.token}", viewId = "/pass_recover.xhtml")
@Named("PasswordRecoveryBean")
@RequestScoped
//implementar URLAction
public class PasswordRecoveryController extends BasicBeanContent<PasswordRecovery, PasswordRecoveryRepository> implements Serializable {

    private String token="";
    private String username;
    private String message;
    private boolean error;
    
    /**
     *
     */
    public PasswordRecoveryController(){
        super();
    }
    
    /**
     *
     * @return
     */
    public boolean isError() {
        return error;
    }

    /**
     *
     * @param error
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }
    
    /**
     *
     */
    @Override
    public void insert() {
        this.repository= new PasswordRecoveryRepository(ApplicationUtilies.catchEntityManager());
        this.getRepository().insert(this.entity);
        this.entity=new PasswordRecovery();
    }

    /**
     *
     */
    @Override
    public void remove() {
        this.repository= new PasswordRecoveryRepository(ApplicationUtilies.catchEntityManager());
        this.getRepository().remove(entity);
        this.listOfEntities.clear();
        this.entity=new PasswordRecovery();
    }

    /**
     *
     */
    @Override
    public void update() {
         this.repository= new PasswordRecoveryRepository(ApplicationUtilies.catchEntityManager());
        this.getRepository().update(entity);
        this.entity=new PasswordRecovery();
        this.listOfEntities.clear();
    }
    
    /**
     *
     */
    public void recover(){
        UsuarioRepository userRep = new UsuarioRepository(ApplicationUtilies.catchEntityManager());
        Usuario user = userRep.loadLoggedUser(this.username);
        this.entity=new PasswordRecovery();
        this.entity.setUsuario(user);
        this.entity.generateToken();
        this.repository = new PasswordRecoveryRepository(ApplicationUtilies.catchEntityManager());
        this.repository.removeByID(user.getId()); //falta implementar
        this.repository.insert(this.entity);
        EmailBuilder email = new EmailBuilder();
        try {
            email.configure(user.getEmail());
            email.setAsRecoveryPassMessage(this.entity.getToken());
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(PasswordRecoveryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @return
     */
    @URLAction
    public String checkToken(){
        if(this.token.isEmpty()){
            return "pretty:erro";
        }
        this.repository = new PasswordRecoveryRepository(ApplicationUtilies.catchEntityManager());
        this.entity = this.repository.getById(token);
        if(this.entity == null)
            return "pretty:erro";
        return "sucess";
    }
    
    /**
     *
     */
    public void resetPassword(){
        UsuarioRepository userRep = new UsuarioRepository(ApplicationUtilies.catchEntityManager());
        userRep.update(this.entity.getUsuario());
        this.repository = new PasswordRecoveryRepository(ApplicationUtilies.catchEntityManager());
        this.repository.removeByID(this.entity.getUsuario().getId());
        this.entity=new PasswordRecovery();
    }
    
}
