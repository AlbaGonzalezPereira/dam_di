
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author alba_
 */
public class TextFieldPersonalizado extends JTextField implements Serializable {

    private int columnas;
    private Color colorFondo;

    //constructor vacío
    public TextFieldPersonalizado() {
    }
    
    //constructor con argumentos
    public TextFieldPersonalizado(int columnas, Color colorFondo) {
        this.columnas = columnas;
        this.colorFondo = colorFondo;
        //modificamos el color y las columnas
        this.setColorFondo(colorFondo);
        this.setColumnas(columnas);
    }

    /**
     * Get the value of columnas
     *
     * @return the value of columnas
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Set the value of columnas
     *
     * @param columnas new value of columnas
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
        this.setColumns(columnas);
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
