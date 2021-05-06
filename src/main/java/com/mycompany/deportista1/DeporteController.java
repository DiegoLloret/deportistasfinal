/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.deportista1;

import com.mycompany.deportista1.DAO.DeporteDAO;
import com.mycompany.deportista1.models.Deporte;
import java.io.IOException;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Alumno 3
 */
public class DeporteController  {
   @FXML
    private Button modificar2;

    @FXML
    private Button nuevo;

    @FXML
    private Button eliminar;

    @FXML
    private Button actualizar;

    @FXML
    private TableColumn<Deporte, String> colTipo;

    @FXML
    private Button resetear;

    @FXML
    private Button volver;

    @FXML
    private TableColumn<Deporte, String> colNombre;

    @FXML
    private TextField fldNombre;

    @FXML
    private TextField fldTipo;

    @FXML
    private TableView<Deporte> tvdeporte1;
     @FXML
    private  ObservableList<Deporte> oldeportes;
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
      @FXML
    private void showDeporte() throws IOException, SQLException {
        DeporteDAO adao =new DeporteDAO();
       
        try {
            adao.conectar();
           // AlertsUtil.mostrarInfo("Conexion sin errores");
            oldeportes= FXCollections.observableArrayList();
               adao.verDeportes(oldeportes);
           System.out.println("size: "+oldeportes.size());
           // tvdeportista1=adao.verDeportistas();
            // tvdeportista1.getColumns().addAll(colNombre,colFecha,colAltura,colNacionalidad,colDorsal,colDeporte,colEquipo);
            System.out.println("paso0 por tvdeportista1");
            //tvdeportista1 = new  TableView<Deportista>();
            tvdeporte1.setItems(oldeportes);
            colNombre.setCellValueFactory(new PropertyValueFactory<Deporte,String>("nombre"));
            colTipo.setCellValueFactory(new PropertyValueFactory<Deporte,String>("tipo"));
             //tvdeportista1.getColumns().addAll(colNombre);
             
        } catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }
    }
    @FXML
    private void AddDeporte()throws IOException, SQLException {
       DeporteDAO adao =new DeporteDAO();
 
       
        if(fldNombre.getText().isEmpty()||fldTipo.getText().isEmpty()){
           AlertsUtil.mostrarError("Rellena todos los campos");
        }else{
        
             Deporte de = new Deporte(
                     fldNombre.getText(),
                     fldTipo.getText());
           
          try{
            adao.conectar();
           adao.insertarDeporte(fldNombre.getText(),fldTipo.getText());
         oldeportes.add(de);
      
          }catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }

        }
       
    }
     @FXML
    private void  borrarDeporte()throws IOException, SQLException {
        DeporteDAO adao =new DeporteDAO();
        if(tvdeporte1.getSelectionModel().isEmpty()){
            AlertsUtil.mostrarError("Selecciona un deporte");
        }else{
           
             try{
            adao.conectar();
           adao.deleteDeporte(tvdeporte1.getSelectionModel().getSelectedItem().getNombre());
           oldeportes.remove(tvdeporte1.getSelectionModel().getSelectedItem());
          }catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }
            
        }
    }
      @FXML
    private void  modificarDeporte()throws IOException, SQLException {
       DeporteDAO adao =new DeporteDAO();
        if(tvdeporte1.getSelectionModel().isEmpty()||
                (fldNombre.getText().isEmpty()||fldTipo.getText().isEmpty())){
           AlertsUtil.mostrarError("Rellena todos los campos y selecciona un equipo");
    }else{
          String nombre= oldeportes.get(tvdeporte1.getSelectionModel().getSelectedIndex()).getNombre();
           String tipo= oldeportes.get(tvdeporte1.getSelectionModel().getSelectedIndex()).getTipo();
           
          if(!fldNombre.getText().isEmpty()){
              nombre=fldNombre.getText();
          }
           if(!fldTipo.getText().isEmpty()){
              tipo=fldTipo.getText();
          }
      
            try{
                 adao.conectar();
           adao.modificarDeporte(fldNombre.getText(),fldTipo.getText());
                oldeportes.set(tvdeporte1.getSelectionModel().getSelectedIndex(),
                     new Deporte(nombre,tipo));
      
          }catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }
 
           }
        }
      @FXML
   private void presionado() {
    
    String nombre= oldeportes.get(tvdeporte1.getSelectionModel().getSelectedIndex()).getNombre();
    fldNombre.setText(nombre);
    
    String tipo= oldeportes.get(tvdeporte1.getSelectionModel().getSelectedIndex()).getTipo();
    fldTipo.setText(tipo); 
    }
@FXML
   private void resetear() {
      
    fldNombre.setText("");
 
    fldTipo.setText("");
  
   }
}
