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
    @NamedQuery (name="Orgao.findAll", query="SELECT a FROM Orgao a"),
    @NamedQuery (name="Orgao.getById", query="SELECT a FROM Orgao a WHERE a.id = :id")
})
public class Orgao implements Serializable {
    @Id
    @GeneratedValue    
    private Long id;
    private String nome;
    private String sigla;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Orgao() {
    }

    public long getId() {
        return id;
    }
    
}
