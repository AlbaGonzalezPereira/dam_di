package com.mycompany.gonzalez_pereira_alba_maria_t1_ud3;

import java.awt.Color;
import java.awt.Font;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JPasswordField;

/**
 * Clase de un componente de contraseña. Hereda de JPasswordField
 * @author alba_
 */
public class PassWordComponent extends JPasswordField implements Serializable {
    
    private Color colorFondo;
    
    private Color colorTexto;
    
    private Font fuente;
    
    
    private int tamanho;
    
    /**
     * Constructor
     */
    public PassWordComponent() {
        //aplicamos características por defecto:
        colorFondo = Color.YELLOW;
        colorTexto = Color.darkGray;
        fuente = new Font("Calibri", Font.PLAIN, 12);
        tamanho = 20;
        
        //llamamos a los setters:
        setColorFondo(colorFondo);
        setColorTexto(colorTexto);
        setFuente(fuente);
        setTamanho(tamanho);
        
    }
    

    /**
     * Get the value of tamanho
     *
     * @return the value of tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Set the value of tamanho
     *
     * @param tamanho new value of tamanho
     */
    public void setTamanho(int tamanho) {
        setColumns(tamanho); //pasamos al tamaño a las columns
        this.tamanho = tamanho;
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
  
} //fin clase
