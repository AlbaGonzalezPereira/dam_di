
package com.mycompany.gonzalezpereiraalba_examenfinal;

import java.awt.Color;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author a24exame-dam-f
 */
public class TextFieldComponent extends JTextField implements Serializable {
    
        private int tamano;
        
    private Color color;
    
    public TextFieldComponent() {
        this.tamano = 10;
        this.color = Color.BLUE;
        this.setForeground(Color.WHITE);
        this.setBackground(color);
        this.setColumns(tamano);
       
    }

    /**
     * Get the value of color
     *
     * @return the value of color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set the value of color
     *
     * @param color new value of color
     */
    public void setColor(Color color) {
        this.color = color;
        this.setBackground(color);
    }


    /**
     * Get the value of tamano
     *
     * @return the value of tamano
     */
    public int getTamanho() {
        return tamano;
    }

    /**
     * Set the value of tamano
     *
     * @param tamanho new value of tamano
     */
    public void setTamanho(int tamanho) {
        this.tamano = tamanho;
        this.setColumns(tamanho);
    }

    
    
    
    
}
