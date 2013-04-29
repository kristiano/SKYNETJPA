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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries ({
    @NamedQuery (name="Servidor.findAll", query="SELECT a FROM Servidor a"),
    @NamedQuery (name="Servidor.getById", query="SELECT a FROM Servidor a WHERE a.id = :id")
})
public class Servidor implements Serializable,BaseEntity{
   @Id
   @GeneratedValue    
   private Long id;
   @OneToMany
   private List<VidaFuncional> vidaFuncional;
   private String cpf;
   private String nome;
   @OneToOne(mappedBy="servidor")
   private Prontuario prontuario;

    public Servidor() {
        this.vidaFuncional = new ArrayList<VidaFuncional>();
        
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    
    public List<VidaFuncional> getVidaFuncional() {
        return vidaFuncional;
    }

    public void setVidaFuncional(List<VidaFuncional> vidaFuncional) {
        this.vidaFuncional = vidaFuncional;
    }

   

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public Long getId() {
        return id;
    }
   
  
    
}
