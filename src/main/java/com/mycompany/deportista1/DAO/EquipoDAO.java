/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deportista1.DAO;

import com.mycompany.deportista1.App;
import com.mycompany.deportista1.models.Equipo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 *
 * @author Alumno 3
 */
public class EquipoDAO {
    public Connection conn;
    public void conectar() throws ClassNotFoundException, SQLException,IOException {
     Properties configuration = new Properties();
        configuration.load(new FileInputStream(new File(App.class.getResource("connectionDB.properties").getPath())));
        String host = configuration.getProperty("host");
        String port = configuration.getProperty("port");
        String name = configuration.getProperty("name");
        String username = configuration.getProperty("username");
        String password = configuration.getProperty("password");

        conn = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }
    public void desconectar() throws SQLException{
        conn.close();
    }
     public void  verEquipos(ObservableList<Equipo> olequipos)throws SQLException{
        TableView<Equipo> tvequipos =new TableView<>();
        String sql ="select equipos.nombre,equipos.pais from equipos;";
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
        while (resultado.next()){
            Equipo e = new Equipo(
            resultado.getString(1),
            resultado.getString(2));
         
            System.out.println("e: "+e.toString());
            olequipos.add(e);
        }
}
      public void insertarEquipo(String nombre,String pais) throws SQLException{
          String sql ="insert into equipos (nombre,pais) values('"+nombre+"','"+pais+"');";
           System.out.println(sql);
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
       
    }
      public void deleteEquipo (String nombre) throws SQLException{
        String sql=" delete from equipos where nombre='"+nombre+"';";
        System.out.println(sql);
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
    }
      public void modificarEquipo(String nombre,String pais) throws SQLException{
        String sql ="call deportistas.ModificarEquipo('"+nombre+"','"+pais+"');";
        System.out.println(sql);
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
    }
}