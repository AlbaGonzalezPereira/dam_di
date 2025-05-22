
package pantallas;

import java.io.Serializable;

/**
 *
 * @author alba_
 */
public class Data implements Serializable{
    private String lugar;
    private String activo;
    private String edicion;
    private int maxParticipantes;

    public Data() {
    }

    public Data(String lugar, String activo, String edicion, int maxParticipantes) {
        this.lugar = lugar;
        this.activo = activo;
        this.edicion = edicion;
        this.maxParticipantes = maxParticipantes;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    @Override
    public String toString() {
        return "Data{" + "lugar=" + lugar + ", activo=" + activo + ", edicion=" + edicion + ", maxParticipantes=" + maxParticipantes + '}';
    }
    
    
}
