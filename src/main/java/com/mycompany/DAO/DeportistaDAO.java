/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.models.Deportista;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 *
 * @author Diego
 */
public class DeportistaDAO {
   public Connection conn;
    public void conectar() throws ClassNotFoundException, SQLException,IOException {
     String conex= LeeFichero.leeConexion("C:/trabajo final/conexion.txt");
        conn=DriverManager.getConnection(conex);
    }
    public void desconectar() throws SQLException{
        conn.close();
    }
    public List<Deportista> listDeportistas() throws SQLException{
        List<Deportista> deportistas =new ArrayList<>();
        String sql ="select deportista.nombre,deportista.fecha_nacimiento,deportista.altura,deportista.nacionalidad,deportista.dorsal,deportes.nombre,equipos.nombre from deportista inner join deportes on deportista.deporte_jugado=deportes.id_deporte inner join  equipos on equipos.id_equipos=deportista.equipo;";
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
        while (resultado.next()){
            Deportista d = new Deportista();
            d.setNombre(resultado.getString(1));
            d.setFecha_nacimiento(resultado.getDate(2));
            d.setAltura(resultado.getInt(3));
            d.setNacionalidad(resultado.getString(4));
            d.setDorsal(resultado.getInt(5));
            d.setDeporte_jugado(resultado.getString(6));
            d.setEquipo(resultado.getString(7));
            deportistas.add(d);
        }
        return deportistas;
    } 
    public TableView<Deportista> verDeportistas()throws SQLException{
        TableView<Deportista> tvdeportistas =new TableView<>();
        ObservableList<Deportista> oldeportistas=FXCollections.observableArrayList();
        String sql ="select deportista.nombre,deportista.fecha_nacimiento,deportista.altura,deportista.nacionalidad,deportista.dorsal,deportes.nombre,equipos.nombre from deportista inner join deportes on deportista.deporte_jugado=deportes.id_deporte inner join  equipos on equipos.id_equipos=deportista.equipo;";
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
        while (resultado.next()){
            Deportista d = new Deportista();
            d.setNombre(resultado.getString(1));
            d.setFecha_nacimiento(resultado.getDate(2));
            d.setAltura(resultado.getInt(3));
            d.setNacionalidad(resultado.getString(4));
            d.setDorsal(resultado.getInt(5));
            d.setDeporte_jugado(resultado.getString(6));
            d.setEquipo(resultado.getString(7));
            System.out.println("d: "+d.getNombre());
            oldeportistas.add(d);
        }
        tvdeportistas.setItems(oldeportistas);
        
        return tvdeportistas;
    }
    
}
