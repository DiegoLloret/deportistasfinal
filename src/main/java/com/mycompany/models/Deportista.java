/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Diego
 */
public class Deportista {
      private final StringProperty nombre;
      private final ObjectProperty<Date> fecha_nacimiento;
      private final IntegerProperty altura;
      private final StringProperty nacionalidad;
     
     private IntegerProperty dorsal;
     private StringProperty deporte_jugado;
     private StringProperty equipo;

   

    public Deportista( String nombre,Date fecha_nacimiento,int altura,String nacionalidad,int dorsal, String deporte_jugado, String equipo) {
       
         this.nombre = new SimpleStringProperty(nombre);
         
       this.fecha_nacimiento = new SimpleObjectProperty<>(fecha_nacimiento);
        this.altura =  new SimpleIntegerProperty(altura);
        this.nacionalidad = new SimpleStringProperty(nacionalidad); 
       
        this.dorsal =new SimpleIntegerProperty(dorsal);
        this.deporte_jugado = new SimpleStringProperty(deporte_jugado);
        this.equipo =  new SimpleStringProperty(equipo);
    }
    
    
    public String getNombre() {
         return nombre.get();
    }

    
    public void setNombre(String nombre) {
             this.nombre.set(nombre);
      
    }

    
    public String getNacionalidad() {
        return nacionalidad.get();
    }

    
    public void setNacionalidad(String nacionalidad) {
       this.nacionalidad.set(nacionalidad);
    }

    
    public Date getFecha_nacimiento() {
      return fecha_nacimiento.get();
    }

    
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento.set(fecha_nacimiento);
    }

    
    public int getAltura() {
        return altura.get();
    }

    
    public void setAltura(int altura) {
        this.altura.set(altura);
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
    
    
    public String toString1()
    {
        
       return this.getNombre()+this.getFecha_nacimiento()+this.getAltura()+this.getNacionalidad()+this.getDorsal()+this.getDeporte_jugado()+this.getEquipo();
    }
    
}
