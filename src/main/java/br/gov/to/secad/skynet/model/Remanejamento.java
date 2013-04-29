/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.skynet.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author SKYNET
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Remanejamento.findAll", query = "SELECT a FROM Remanejamento a"),
    @NamedQuery(name = "Remanejamento.getById", query = "SELECT a FROM Remanejamento a WHERE a.id = :id")
})
public class Remanejamento implements Serializable{
    @Id
    @GeneratedValue
     private Long id;
     private String processo;
     private Integer sequencia;
     private String status;
     private String cid;
     @Temporal(javax.persistence.TemporalType.DATE)
     private Date dataEntrada;
     @Temporal(javax.persistence.TemporalType.DATE)
     private Date dataInicio;
     @Temporal(javax.persistence.TemporalType.DATE)
     private Date dataFim;
     private String periodo;

    public Remanejamento() {
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Long getId() {
        return id;
    }
     
    
}
