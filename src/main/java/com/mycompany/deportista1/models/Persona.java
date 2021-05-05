/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deportista1.models;

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
public abstract class Persona {
    
     private StringProperty nombre;
     private StringProperty nacionalidad;
     private ObjectProperty<Date> fecha_nacimiento;
     private IntegerProperty altura;

    public Persona() {
    }

    public Persona(String nombre, String nacionalidad, Date fecha_nacimiento, int altura) {
        this.nombre = new SimpleStringProperty(nombre);
        this.nacionalidad = new SimpleStringProperty(nacionalidad);
        this.fecha_nacimiento = new SimpleObjectProperty<>(fecha_nacimiento);
        this.altura =  new SimpleIntegerProperty(altura);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return  nombre.get();
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
         this.nombre.set(nombre);
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad.get();
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad.set(nacionalidad);
    }

    /**
     * @return the fecha_nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento.get();
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(ObjectProperty<Date> fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura.get();
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(IntegerProperty altura) {
        this.altura = altura;
    }

     public abstract String toString();

    
}
