package entidades;

import DAO.Activa;

/**
 *
 * @author alba_
 */

public class Aula {
    private String nombreAula;
    private Activa activa;
    private String edicion;
    private int maxParticipantes;

    public Aula(String nombreAula, Activa activa, String edicion, int maxParticipantes) {
        this.nombreAula = nombreAula;
        this.activa = activa;
        this.edicion = edicion;
        this.maxParticipantes = maxParticipantes;
    }

    public String getNombreAula() {
        return nombreAula;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public Activa getActiva() {
        return activa;
    }

    public void setActiva(Activa activa) {
        this.activa = activa;
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
        return "Lugar = " + nombreAula + ", activa=" + activa + ", edicion=" + edicion + ", maxParticipantes=" + maxParticipantes;
    }
    
    
    
}
