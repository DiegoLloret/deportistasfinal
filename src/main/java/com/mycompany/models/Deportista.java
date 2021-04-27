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
public class Deportista extends Persona{

     int dorsal;
     String deporte_jugado;
     String equipo;

    public Deportista() {
    }

    public Deportista(int dorsal, String deporte_jugado, String equipo, String nombre, String nacionalidad, Date fecha_nacimiento, int altura) {
        super(nombre, nacionalidad, fecha_nacimiento, altura);
        this.dorsal = dorsal;
        this.deporte_jugado = deporte_jugado;
        this.equipo = equipo;
    }
    
    
    @Override
    public String getNombre() {
         return nombre;
    }

    @Override
    public void setNombre(String nombre) {
      this.nombre=nombre;
    }

    @Override
    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public void setNacionalidad(String nacionalidad) {
       this.nacionalidad=nacionalidad;
    }

    @Override
    public Date getFecha_nacimiento() {
      return fecha_nacimiento;
    }

    @Override
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento=fecha_nacimiento;
    }

    @Override
    public int getAltura() {
        return altura;
    }

    @Override
    public void setAltura(int altura) {
        this.altura=altura;
    }

    /**
     * @return the dorsal
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     * @param dorsal the dorsal to set
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /**
     * @return the deporte_jugado
     */
    public String getDeporte_jugado() {
        return deporte_jugado;
    }

    /**
     * @param deporte_jugado the deporte_jugado to set
     */
    public void setDeporte_jugado(String deporte_jugado) {
        this.deporte_jugado = deporte_jugado;
    }

    /**
     * @return the equipo
     */
    public String getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    
}
