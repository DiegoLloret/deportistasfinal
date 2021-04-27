/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import java.sql.Date;

/**
 *
 * @author Diego
 */
public abstract class Persona {
     String nombre;
     String nacionalidad;
     Date fecha_nacimiento;
     int altura;

    public Persona() {
    }

    public Persona(String nombre, String nacionalidad, Date fecha_nacimiento, int altura) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.altura = altura;
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
