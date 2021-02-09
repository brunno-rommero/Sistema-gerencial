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
public class MovVenda {
    
    private int idVenda;
    private Date dataVenda;
    private Date dataInicial;
    private Date datafinal;
    private int usuario;
    private String formPag;
    private Double vlrTotal;
    
    
    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the dataInicial
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * @param dataInicial the dataInicial to set
     */
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * @return the datafinal
     */
    public Date getDatafinal() {
        return datafinal;
    }

    /**
     * @param datafinal the datafinal to set
     */
    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    /**
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the formPag
     */
    public String getFormPag() {
        return formPag;
    }

    /**
     * @param formPag the formPag to set
     */
    public void setFormPag(String formPag) {
        this.formPag = formPag;
    }

    /**
     * @return the dataVenda
     */
    public Date getDataVenda() {
        return dataVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * @return the vlrTotal
     */
    public Double getVlrTotal() {
        return vlrTotal;
    }

    /**
     * @param vlrTotal the vlrTotal to set
     */
    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }
    
    
    
}
