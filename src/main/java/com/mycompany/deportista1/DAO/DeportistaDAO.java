/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deportista1.DAO;

import com.mycompany.deportista1.DAO.LeeFichero;
import com.mycompany.deportista1.models.Deportista;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    /*
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
    } */
   // public TableView<Deportista> verDeportistas()throws SQLException{
     public void  verDeportistas(ObservableList<Deportista> oldeportistas)throws SQLException{
        TableView<Deportista> tvdeportistas =new TableView<>();
      
        String sql ="select deportista.nombre,deportista.fecha_nacimiento,deportista.altura,deportista.nacionalidad,deportista.dorsal,deportes.nombre,equipos.nombre from deportista inner join deportes on deportista.deporte_jugado=deportes.id_deporte inner join  equipos on equipos.id_equipos=deportista.equipo;";
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
        while (resultado.next()){
            Deportista d = new Deportista(
            resultado.getString(1),
            resultado.getDate(2),
            resultado.getInt(3),
            resultado.getString(4),
            resultado.getInt(5),
            resultado.getString(6),
            resultado.getString(7));
         /*  Deportista d = new Deportista();
            d.setNombre(new SimpleStringProperty(resultado.getString(1)));
            d.setFecha_nacimiento(new SimpleObjectProperty<>(resultado.getDate(2)));
            d.setAltura(new SimpleIntegerProperty(resultado.getInt(3)));
            d.setNacionalidad(new SimpleStringProperty(resultado.getString(4)));
            d.setDorsal(resultado.getInt(5));
            d.setDeporte_jugado (resultado.getString(6));
            d.setEquipo(resultado.getString(7));*/
            System.out.println("d: "+d.toString());
            oldeportistas.add(d);
        }
       // tvdeportistas.setItems(oldeportistas);
        
        //return tvdeportistas;
       // return oldeportistas;
    }
    public void insertarDeportista(String nombre,Date fecha,int altura,String nacionalidad,int dorsal,String deporte,String equipo) throws SQLException{
          String sql ="call deportistas.InsertarDeportista('"+nombre+"','"+fecha+"',"+altura+
                ",'"+nacionalidad+"',"+dorsal+",'"+deporte+"','"+equipo+"');";
           System.out.println(sql);
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
       
    }
    public void deleteDeportista (String nombre) throws SQLException{
        String sql=" delete from deportista where nombre='"+nombre+"';";
        System.out.println(sql);
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
    }
    public void modificarDeportista(String nombre,Date fecha,int altura,String nacionalidad,int dorsal,String deporte,String equipo) throws SQLException{
        String sql ="call deportistas.ModificarDeportista('"+nombre+"','"+fecha+"',"+altura+
                ",'"+nacionalidad+"',"+dorsal+",'"+deporte+"','"+equipo+"');";
        System.out.println(sql);
        PreparedStatement sentencia =conn.prepareStatement(sql);
        ResultSet resultado= sentencia.executeQuery();
    }
}
