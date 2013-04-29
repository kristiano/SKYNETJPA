/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.model;

import br.gov.to.secad.skynet.util.BaseEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author SKYNET
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class TheUser extends Usuario implements Serializable,BaseEntity {

    public TheUser() {
         super();
        this.permissao = "USER";
    }
    
     @Override
    public Object clone() throws CloneNotSupportedException {
        TheUser clone = new TheUser();
        clone.setDataCadastro(dataCadastro);
        clone.setEmail(email);
        clone.setEnabled(enabled);
        clone.setId(id);
        clone.setNome(nome);
        clone.setPassword(password);
        clone.setPermissao(permissao);
        clone.setUsername(username);
        return clone;
    }
}
