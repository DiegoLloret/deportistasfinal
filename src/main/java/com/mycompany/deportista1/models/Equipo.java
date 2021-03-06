/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deportista1.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Alumno 3
 */
public class Equipo {
    
    private StringProperty nombre;
     private StringProperty pais;

    public Equipo() {
    }

    public Equipo(String nombre, String pais) {
        this.nombre =new SimpleStringProperty( nombre);
        this.pais = new SimpleStringProperty(pais);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre.get();
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais.get();
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais.set(pais);
    }
     
     public String toString()
    {
        
       return ""+getNombre()+getPais();
      
    }
}
