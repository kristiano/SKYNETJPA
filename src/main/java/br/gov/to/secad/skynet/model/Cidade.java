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

/**
 *
 * @author SKYNET
 */
@Entity
@NamedQueries ({
    @NamedQuery (name="Cidade.findAll", query="SELECT a FROM Cidade a"),
    @NamedQuery (name="Cidade.getById", query="SELECT a FROM Cidade a WHERE a.id = :id")
})
public class Cidade implements Serializable {
    @Id
    @GeneratedValue    
    private Long id;
    private String nome;

    public Cidade() {
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
