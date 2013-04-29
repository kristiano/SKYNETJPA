/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author SKYNET
 */
@Entity
@NamedQueries ({
    @NamedQuery (name=" Cargo.findAll", query="SELECT a FROM  Cargo a"),
    @NamedQuery (name=" Cargo.getById", query="SELECT a FROM  Cargo a WHERE a.id = :id")
})
public class Cargo implements Serializable {
    @Id 
    @GeneratedValue    
    private Long id;
    private String nome;
    @ManyToOne(cascade= CascadeType.ALL)
    private Escolaridade escolaridade;

    public Cargo() {
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }
    
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }
    
    
}
