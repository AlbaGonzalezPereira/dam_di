package com.ventanaemergente.ventanas;

import java.util.ArrayList;

public class Alumno {
        private String nombre;
        private String apellidos;
        private String email;
        private String codigoPostal;
        private String nif;
        private ArrayList <Modulo> modulos;
        Alumno(){
            nombre=new String();
            apellidos=new String();
            email=new String();
            codigoPostal=new String();
            nif=new String();
            modulos=new ArrayList<Modulo>();
        }
        Alumno(String nombre, String apellidos, String email, String codigoPostal, String nif, ArrayList <Modulo> modulos){
            this.nombre=nombre;
            this.apellidos=apellidos;
            this.email=email;
            this.codigoPostal=codigoPostal;
            this.nif=nif;
            this.modulos=modulos;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCodigoPostal() {
            return codigoPostal;
        }

        public void setCodigoPostal(String codigoPostal) {
            this.codigoPostal = codigoPostal;
        }

        public String getNif() {
            return nif;
        }

        public void setNif(String nif) {
            this.nif = nif;
        }

        public ArrayList<Modulo> getModulos() {
            return modulos;
        }

        public void setModulos(ArrayList<Modulo> modulos) {
            this.modulos = modulos;
        }

        @Override
        public String toString() {
            return "Alumno{" +
                    "nombre='" + nombre + '\'' +
                    ", apellidos='" + apellidos + '\'' +
                    ", email='" + email + '\'' +
                    ", codigoPostal='" + codigoPostal + '\'' +
                    ", nif='" + nif + '\'' +
                    ", modulos=" + modulos +
                    '}';
        }
    }
