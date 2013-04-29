/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author SKYNET
 */
@Entity
@NamedQueries ({
    @NamedQuery (name="Lotacao.findAll", query="SELECT a FROM Lotacao a"),
    @NamedQuery (name="Lotacao.getById", query="SELECT a FROM Lotacao a WHERE a.id = :id")
})
public class Lotacao implements Serializable {
    @Id
    @GeneratedValue    
    private Long id;
    private String nome;
    @OneToOne
    private Orgao orgao;

    public Lotacao() {
        this.orgao = new Orgao();
        
    }

    public long getId() {
        return id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }
    
    
}
