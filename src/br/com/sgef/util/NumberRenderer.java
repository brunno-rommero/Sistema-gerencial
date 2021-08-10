/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.util;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.SwingConstants;

/**
 *
 * @author Bruno
 */
public class NumberRenderer extends FormatRenderer{
    
    public NumberRenderer(NumberFormat formatter) {
        super(formatter);
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
 
    /**
     *  método retorna formato monetário
     */
    public static NumberRenderer getCurrencyRenderer() {
        return new NumberRenderer(NumberFormat.getCurrencyInstance());
    }
 
    /**
     *  método retorna formato inteiro
     */
    public static NumberRenderer getIntegerRenderer() {
        return new NumberRenderer(NumberFormat.getIntegerInstance());
    }
 
    /**
     *  método retorna formato percentual
     */
    public static NumberRenderer getPercentRenderer() {
        return new NumberRenderer(NumberFormat.getPercentInstance());
    }
     
    /**
     * usar para formatação numerica, com definição de casas decimais
     * @return 
     */
    public static NumberRenderer getNumberRenderer(int fraction) {
        NumberFormat nf=NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(fraction);
        return new NumberRenderer(nf);
    }
    
}
