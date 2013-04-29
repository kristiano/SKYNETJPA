/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.model;

import br.gov.to.secad.skynet.util.BaseEntity;
import br.gov.to.secad.skynet.util.BaseEntityConverter;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author SKYNET
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "VidaFuncional.findAll", query = "SELECT a FROM VidaFuncional a"),
    @NamedQuery(name = "VidaFuncional.getById", query = "SELECT a FROM VidaFuncional a WHERE a.id = :id")
})
public class VidaFuncional implements Serializable, BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Cargo cargo;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Orgao orgao;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Lotacao lotacao;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Cidade cidade;
    private String matricula;
    private Boolean efetivo;
    private Boolean ativo;
    private String vinculo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;
    @OneToOne
    private Prontuario prontuario;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Servidor servidor;

    public VidaFuncional() {
        this.cargo = new Cargo();
        this.cidade = new Cidade();
        this.orgao = new Orgao();
        this.cidade = new Cidade();
        this.lotacao = new Lotacao();
        this.prontuario = new Prontuario();
        this.servidor = new Servidor();
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Lotacao getLotacao() {
        return lotacao;
    }

    public void setLotacao(Lotacao lotacao) {
        this.lotacao = lotacao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Boolean getEfetivo() {
        return efetivo;
    }

    public void setEfetivo(Boolean efetivo) {
        this.efetivo = efetivo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VidaFuncional other = (VidaFuncional) obj;
        if ((this.matricula == null) ? (other.matricula != null) : !this.matricula.equals(other.matricula)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return this.matricula;
    }
    
    
}
