package com.mycompany.gonzalez_pereira_alba_maria_t1_ud3;

import java.awt.Color;
import java.awt.Font;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

/**
 *
 * @author alba_
 */
public class SeparadorComponent extends JSeparator implements Serializable {

    private Color color;
    private boolean borde;

    private Color colorBorde;

    private String tooltip;

    public SeparadorComponent() {
        color = Color.GREEN;
        borde = true;
        tooltip = "Soy un separador";
        colorBorde = Color.RED;

        setColor(color);
        setTooltip(tooltip);
        setBorde(borde);
        setColorBorde(colorBorde);
    }

    /**
     * Get the value of tooltip
     *
     * @return the value of tooltip
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * Set the value of tooltip
     *
     * @param tooltip new value of tooltip
     */
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
        setToolTipText(tooltip);

    }

    /**
     * Get the value of borde
     *
     * @return the value of borde
     */
    public boolean isBorde() {
        return borde;
    }

    /**
     * Set the value of borde
     *
     * @param borde new value of borde
     */
    public void setBorde(boolean borde) {
        this.borde = borde;
        if (borde) {
            setBorder(new LineBorder(Color.BLACK, 2));
        } else {
            setBorder(null);
        }
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
        setBackground(color);
    }

    /**
     * Get the value of colorBorde
     *
     * @return the value of colorBorde
     */
    public Color getColorBorde() {
        return colorBorde;
    }

    /**
     * Set the value of colorBorde
     *
     * @param colorBorde new value of colorBorde
     */
    public void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
        if (borde) {
            setBorder(new LineBorder(colorBorde, 2));
        }

    }

}
