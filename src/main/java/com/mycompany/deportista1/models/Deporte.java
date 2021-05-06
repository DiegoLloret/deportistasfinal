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
public class Deporte {
    private StringProperty nombre;
     private StringProperty tipo;

    public Deporte() {
    }

    public Deporte(String nombre, String tipo) {
        this.nombre =new SimpleStringProperty( nombre);
        this.tipo = new SimpleStringProperty(tipo);
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
    public String getTipo() {
        return tipo.get();
    }

    /**
     * @param tipo the pais to set
     */
    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }
     
     public String toString()
    {
        
       return ""+getNombre()+getTipo();
      
    }
}
