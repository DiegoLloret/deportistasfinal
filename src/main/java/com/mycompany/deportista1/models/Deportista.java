/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deportista1.models;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Diego
 */
public class Deportista extends Persona{
    
     
     private IntegerProperty dorsal;
     private StringProperty deporte_jugado;
     private StringProperty equipo;

    public Deportista(){}

    public Deportista( String nombre,Date fecha_nacimiento,int altura,String nacionalidad,int dorsal, String deporte_jugado, String equipo) {
                   super(nombre,nacionalidad,fecha_nacimiento,altura);
        this.dorsal =new SimpleIntegerProperty(dorsal);
        this.deporte_jugado = new SimpleStringProperty(deporte_jugado);
        this.equipo =  new SimpleStringProperty(equipo);
    }
    /**
     * @return the dorsal
     */
    public int getDorsal() {
        return dorsal.get();
    }

    /**
     * @param dorsal the dorsal to set
     */
    public void setDorsal(int dorsal) {
        this.dorsal.set(dorsal);
    }

    /**
     * @return the deporte_jugado
     */
    public String getDeporte_jugado() {
        return deporte_jugado.get();
    }

    /**
     * @param deporte_jugado the deporte_jugado to set
     */
    public void setDeporte_jugado(String deporte_jugado) {
        this.deporte_jugado.set(deporte_jugado);
    }

    /**
     * @return the equipo
     */
    public String getEquipo() {
        return equipo.get();
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(String equipo) {
        this.equipo.set(equipo); 
    }
    
     @Override
    public String toString()
    {
        
       return ""+getNombre()+getFecha_nacimiento()+getNacionalidad()+getAltura()+getDorsal()+getDeporte_jugado()+getEquipo();
      
    }

   
   
}
