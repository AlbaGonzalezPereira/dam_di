
import java.io.Serializable;


/**
 *
 * @author alba_
 */
public class Datos implements Serializable{
    private String valorNombre;
    private int valorEdad;

    public Datos(String valorNombre, int valorEdad) {
        this.valorNombre = valorNombre;
        this.valorEdad = valorEdad;
    }

    public Datos() {
    }

    public String getValorNombre() {
        return valorNombre;
    }

    public void setValorNombre(String valorNombre) {
        this.valorNombre = valorNombre;
    }

    public int getValorEdad() {
        return valorEdad;
    }

    public void setValorEdad(int valorEdad) {
        this.valorEdad = valorEdad;
    }

    @Override
    public String toString() {
        return "Datos: " + "valorNombre=" + valorNombre + ", valorEdad=" + valorEdad;
    }  
}
