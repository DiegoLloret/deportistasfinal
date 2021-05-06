/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deportista1.DAO;

import com.mycompany.deportista1.DAO.LeeFichero;
import com.mycompany.deportista1.models.Deporte;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 *
 * @author Alumno 3
 */
public class DeporteDAO {
    public Connection conn;
    public void conectar() throws ClassNotFoundException, SQLException,IOException {
     String conex= LeeFichero.leeConexion("C:/trabajo final/conexion.txt");
        conn=DriverManager.getConnection(conex);
    }
    public void desconectar() throws SQLException{
        conn.close();
    }
     public void  verDeportes(ObservableList<Deporte> oldeportes)throws SQLException{
        TableView<Deporte> tvdeportes =new TableView<>();
        String sql ="select deportes.nombre,deportes.tipo from deportes;";
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
        while (resultado.next()){
            Deporte de = new Deporte(
            resultado.getString(1),
            resultado.getString(2));
            System.out.println("de: "+de.toString());
            oldeportes.add(de);
        }
}
      public void insertarDeporte(String nombre,String tipo) throws SQLException{
          String sql ="insert into deportes (nombre,tipo) values('"+nombre+"','"+tipo+"');";
           System.out.println(sql);
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
       
    }
      public void deleteDeporte (String nombre) throws SQLException{
        String sql=" delete from deportes where nombre='"+nombre+"';";
        System.out.println(sql);
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
    }
      public void modificarDeporte(String nombre,String tipo) throws SQLException{
        String sql ="call deportistas.ModificarDeporte('"+nombre+"','"+tipo+"');";
        System.out.println(sql);
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
    }
}
