/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.model;

import java.sql.Date;

/**
 *
 * @author Bruno
 */
public class Caixa {
    
    private int idCaixa;
    private Date dataCaixa;
    private String status;
    private Double totalGeral;

    /**
     * @return the idCaixa
     */
    public int getIdCaixa() {
        return idCaixa;
    }

    /**
     * @param idCaixa the idCaixa to set
     */
    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }

    /**
     * @return the dataCaixa
     */
    public Date getDataCaixa() {
        return dataCaixa;
    }

    /**
     * @param dataCaixa the dataCaixa to set
     */
    public void setDataCaixa(Date dataCaixa) {
        this.dataCaixa = dataCaixa;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the totalGeral
     */
    public Double getTotalGeral() {
        return totalGeral;
    }

    /**
     * @param totalGeral the totalGeral to set
     */
    public void setTotalGeral(Double totalGeral) {
        this.totalGeral = totalGeral;
    }
    
    
    
    
}
