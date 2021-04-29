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
public abstract class Persona {
    
     StringProperty nombre;
     StringProperty nacionalidad;
     ObjectProperty<Date> fecha_nacimiento;
     IntegerProperty altura;

    public Persona() {
    }

    public Persona(String nombre, String nacionalidad, Date fecha_nacimiento, int altura) {
        this.nombre = new SimpleStringProperty("nombre");
        this.nacionalidad = new SimpleStringProperty("nacionalidad");
        this.fecha_nacimiento = new SimpleObjectProperty<>(fecha_nacimiento);
        this.altura =  new SimpleIntegerProperty(altura);
    }

    /**
     * @return the nombre
     */
    public abstract String getNombre();
       

    /**
     * @param nombre the nombre to set
     */
    public abstract void setNombre(String nombre);

    /**
     * @return the nacionalidad
     */
    public abstract String getNacionalidad();

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public abstract void setNacionalidad(String nacionalidad);

    /**
     * @return the fecha_nacimiento
     */
    public abstract Date getFecha_nacimiento();

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public abstract void setFecha_nacimiento(Date fecha_nacimiento);

    /**
     * @return the altura
     */
    public abstract int getAltura();

    /**
     * @param altura the altura to set
     */
    public abstract void setAltura(int altura);

    
}
