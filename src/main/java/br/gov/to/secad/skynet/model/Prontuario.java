/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.model;

import br.gov.to.secad.skynet.util.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author SKYNET
 */
@Entity
@NamedQueries ({
    @NamedQuery (name=" Prontuario.findAll", query="SELECT a FROM  Prontuario a"),
    @NamedQuery (name=" Prontuario.getById", query="SELECT a FROM  Prontuario a WHERE a.id = :id"),
    @NamedQuery (name="Prontuario.getByIdNumero", query="SELECT a FROM  Prontuario a WHERE a.numero = :numero")
    
})
public class Prontuario implements Serializable, BaseEntity{ 
    @Id
    @GeneratedValue   
    private Long id;
    private String numero;
    @OneToOne
    private Servidor servidor;
    @OneToMany(fetch= FetchType.EAGER)
    private List<VidaFuncional> vidaFuncionais;
    @OneToMany
    private List<Remanejamento> remanejamentos;
    public Prontuario() {
        this.servidor=new Servidor();
        this.vidaFuncionais = new ArrayList<VidaFuncional>();
        this.remanejamentos = new ArrayList<Remanejamento>();
    }

    @Override
    public Long getId() {
        return id;
    }

    public List<Remanejamento> getRemanejamentos() {
        return remanejamentos;
    }

    public void setRemanejamentos(List<Remanejamento> remanejamentos) {
        this.remanejamentos = remanejamentos;
    }

    public List<VidaFuncional> getVidaFuncionais() {
        return vidaFuncionais;
    }

    public void setVidaFuncionais(List<VidaFuncional> vidaFuncionais) {
        this.vidaFuncionais = vidaFuncionais;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

   
    
}
