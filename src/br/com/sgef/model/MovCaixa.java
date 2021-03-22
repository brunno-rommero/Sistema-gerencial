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
public class MovCaixa {
    
    private int movCaixa;
    private int id_caixa;
    private int id_venda;
    private int idUser;
    private Date dataMov;
    private String tipo;
    private String origemMov;
    private String formPag;
    private Double valor;

    /**
     * @return the movCaixa
     */
    public int getMovCaixa() {
        return movCaixa;
    }

    /**
     * @param movCaixa the movCaixa to set
     */
    public void setMovCaixa(int movCaixa) {
        this.movCaixa = movCaixa;
    }

    /**
     * @return the id_caixa
     */
    public int getId_caixa() {
        return id_caixa;
    }

    /**
     * @param id_caixa the id_caixa to set
     */
    public void setId_caixa(int id_caixa) {
        this.id_caixa = id_caixa;
    }

    /**
     * @return the id_venda
     */
    public int getId_venda() {
        return id_venda;
    }

    /**
     * @param id_venda the id_venda to set
     */
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the dataMov
     */
    public Date getDataMov() {
        return dataMov;
    }

    /**
     * @param dataMov the dataMov to set
     */
    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the origemMov
     */
    public String getOrigemMov() {
        return origemMov;
    }

    /**
     * @param origemMov the origemMov to set
     */
    public void setOrigemMov(String origemMov) {
        this.origemMov = origemMov;
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
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    

      
}
