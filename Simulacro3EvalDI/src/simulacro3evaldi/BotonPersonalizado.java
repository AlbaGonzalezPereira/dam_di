
package simulacro3evaldi;

import java.awt.Color;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author alba_
 */
public class BotonPersonalizado extends JButton implements Serializable {
    
    private Color colorFondo;
    
    public BotonPersonalizado() {
        
        this.colorFondo = Color.BLUE;
        setColorFondo(colorFondo);
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
        this.colorFondo = colorFondo;
        this.setBackground(colorFondo);
    }

    
    
    
    
    
}
