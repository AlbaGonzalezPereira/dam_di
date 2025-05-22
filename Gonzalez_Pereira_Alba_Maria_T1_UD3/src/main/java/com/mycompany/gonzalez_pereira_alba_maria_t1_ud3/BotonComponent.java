package com.mycompany.gonzalez_pereira_alba_maria_t1_ud3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author alba_
 */
public class BotonComponent extends JButton implements Serializable {
    
    private Color colorFondo;
    
    private Color colorTexto;
    
    private int padding;
    
    private String texto;
    
    private Font fuente;

    public BotonComponent() {
        colorFondo = Color.CYAN;
        colorTexto = Color.BLACK;
        padding = 10;
        texto = "Botón";
        fuente = new Font("Calibri", Font.BOLD, 12);
        
        setColorFondo(colorFondo);
        setColorTexto(colorTexto);
        setPadding(padding);
        setTexto(texto);
        setFuente(fuente);
    }
    
    

    /**
     * Get the value of fuente
     *
     * @return the value of fuente
     */
    public Font getFuente() {
        return fuente;
    }

    /**
     * Set the value of fuente
     *
     * @param fuente new value of fuente
     */
    public void setFuente(Font fuente) {
        setFont(fuente);
        this.fuente = fuente;
    }


    /**
     * Get the value of texto
     *
     * @return the value of texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Set the value of texto
     *
     * @param texto new value of texto
     */
    public void setTexto(String texto) {
        setText(texto);
        this.texto = texto;
    }


    /**
     * Get the value of padding
     *
     * @return the value of padding
     */
    public int getPadding() {
        return padding;
    }

    /**
     * Set the value of padding
     *
     * @param padding new value of padding
     */
    public void setPadding(int padding) {
        setMargin(new Insets(padding, padding*2, padding, padding*2));
        this.padding = padding;
    }


    /**
     * Get the value of colorTexto
     *
     * @return the value of colorTexto
     */
    public Color getColorTexto() {
        return colorTexto;
    }

    /**
     * Set the value of colorTexto
     *
     * @param colorTexto new value of colorTexto
     */
    public void setColorTexto(Color colorTexto) {
        setForeground(colorTexto);
        this.colorTexto = colorTexto;
    }


    /**
     * Get the value of colorFondo
     *
     * @return the value of colorFondo
     */
    public Color getColorFondo() {
        return colorFondo;
    }

    /**
     * Set the value of colorFondo
     *
     * @param colorFondo new value of colorFondo
     */
    public void setColorFondo(Color colorFondo) {
        setBackground(colorFondo);
        this.colorFondo = colorFondo;
    }

}