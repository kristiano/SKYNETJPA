
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.model;


import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import br.gov.to.secad.skynet.util.UniqueUser;

/**
 * Classe referente ao Usuario que é uma pessoa física
 *
 * @author Klimaco
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT a FROM Usuario a"),
    @NamedQuery(name = "Usuario.getById", query = "SELECT a FROM Usuario a WHERE a.id = :id")
})
@PrimaryKeyJoinColumn(name = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends Pessoa implements Serializable {

    /**
     *
     */
    @NotEmpty
    @Size(min = 5, max = 20) 
    @UniqueUser(message="Nome de usuário deve ser único")
    protected String username;
    /**
     *
     */
    protected String permissao;
    /**
     *
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dataCadastro;
    /**
     *
     */
    protected boolean enabled;
    /**
     *
     */
    @NotEmpty
    @Size(min = 6, max = 12)
    @Column(columnDefinition = "text")
    protected String password;

    /**
     *
     */
    public Usuario() {
        this.enabled = true;
        
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
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
        password = hash.toString(16);
        this.password = password;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     *
     * @param dataCadastro
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     *
     * @return
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     *
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     *
     * @return
     */
    public String getPermissao() {
        return permissao;
    }

    /**
     *
     * @param permissao
     */
    public void setPermissao(String permissao) {
        this.permissao = permissao;
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

    
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.username != null ? this.username.hashCode() : 0);
        hash = 97 * hash + (this.dataCadastro != null ? this.dataCadastro.hashCode() : 0);
        hash = 97 * hash + (this.password != null ? this.password.hashCode() : 0);
        return hash;
    }

  

   
}
