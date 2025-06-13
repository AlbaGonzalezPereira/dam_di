/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacro3evaldi;

import java.io.Serializable;

/**
 *
 * @author alba_
 */
public class PersonaNombre implements Serializable {
    
    private String nombre;

    public PersonaNombre(String nombre) {
        this.nombre = nombre;
    }

    public PersonaNombre() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
