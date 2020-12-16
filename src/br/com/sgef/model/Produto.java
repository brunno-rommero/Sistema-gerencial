/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.model;

import java.math.BigDecimal;

/**
 *
 * @author Bruno
 */
public class Produto {
    private int id;
    private String descricao;
    private int id_marca;
    private Marca marca;
    private int id_linha;
    private Linha linha;
    private int estoque;
    private BigDecimal pcompra;
    private BigDecimal pvenda;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the id_marca
     */
    public int getId_marca() {
        return id_marca;
    }

    /**
     * @param id_marca the id_marca to set
     */
    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    /**
     * @return the id_linha
     */
    public int getId_linha() {
        return id_linha;
    }

    /**
     * @param id_linha the id_linha to set
     */
    public void setId_linha(int id_linha) {
        this.id_linha = id_linha;
    }

    /**
     * @return the estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the pcompra
     */
    public BigDecimal getPcompra() {
        return pcompra;
    }

    /**
     * @param pcompra the pcompra to set
     */
    public void setPcompra(BigDecimal pcompra) {
        this.pcompra = pcompra;
    }

    /**
     * @return the pvenda
     */
    public BigDecimal getPvenda() {
        return pvenda;
    }

    /**
     * @param pvenda the pvenda to set
     */
    public void setPvenda(BigDecimal pvenda) {
        this.pvenda = pvenda;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @return the linha
     */
    public Linha getLinha() {
        return linha;
    }

    /**
     * @param linha the linha to set
     */
    public void setLinha(Linha linha) {
        this.linha = linha;
    }
    
    
}
