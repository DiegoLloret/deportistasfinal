package com.mycompany.deportista1;

import com.mycompany.deportista1.DAO.EquipoDAO;
import com.mycompany.deportista1.models.Equipo;
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
 *
 * @author Diego
 */
public class Equipo1 {

    @FXML
    private TableColumn<Equipo, String> colPais;

    @FXML
    private Button nuevo;

    @FXML
    private Button eliminar;

    @FXML
    private Button actualizar;

    @FXML
    private TextField fldPais;

    @FXML
    private TableView<Equipo> tvequipo1;

    @FXML
    private Button resetear;

    @FXML
    private Button modificar1;

    @FXML
    private Button volver;

    @FXML
    private TableColumn<Equipo, String> colNombre;

    @FXML
    private TextField fldNombre;
    
    @FXML
    private  ObservableList<Equipo> olequipos;
    
     @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
      @FXML
    private void showEquipo() throws IOException, SQLException {
        EquipoDAO adao =new EquipoDAO();
       
        try {
            adao.conectar();
           // AlertsUtil.mostrarInfo("Conexion sin errores");
            olequipos= FXCollections.observableArrayList();
               adao.verEquipos(olequipos);
           System.out.println("size: "+olequipos.size());
           // tvdeportista1=adao.verDeportistas();
            // tvdeportista1.getColumns().addAll(colNombre,colFecha,colAltura,colNacionalidad,colDorsal,colDeporte,colEquipo);
            System.out.println("paso0 por tvdeportista1");
            //tvdeportista1 = new  TableView<Deportista>();
            tvequipo1.setItems(olequipos);
            colNombre.setCellValueFactory(new PropertyValueFactory<Equipo,String>("nombre"));
            colPais.setCellValueFactory(new PropertyValueFactory<Equipo,String>("pais"));
             //tvdeportista1.getColumns().addAll(colNombre);
             
        } catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }
    }
    @FXML
    private void AddEquipo()throws IOException, SQLException {
       EquipoDAO adao =new EquipoDAO();
 
       
        if(fldNombre.getText().isEmpty()||fldPais.getText().isEmpty()){
           AlertsUtil.mostrarError("Rellena todos los campos");
        }else{
        
             Equipo e = new Equipo(
                     fldNombre.getText(),
                     fldPais.getText());
           
          try{
            adao.conectar();
           adao.insertarEquipo(fldNombre.getText(),fldPais.getText());
         olequipos.add(e);
      
          }catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }

        }
       
    }
     @FXML
    private void  borrarEquipo()throws IOException, SQLException {
        EquipoDAO adao =new EquipoDAO();
        if(tvequipo1.getSelectionModel().isEmpty()){
            AlertsUtil.mostrarError("Selecciona un equipo");
        }else{
           
             try{
            adao.conectar();
           adao.deleteEquipo(tvequipo1.getSelectionModel().getSelectedItem().getNombre());
           olequipos.remove(tvequipo1.getSelectionModel().getSelectedItem());
          }catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }
            
        }
    }
      @FXML
    private void  modificarEquipo()throws IOException, SQLException {
       EquipoDAO adao =new EquipoDAO();
        if(tvequipo1.getSelectionModel().isEmpty()||
                (fldNombre.getText().isEmpty()||fldPais.getText().isEmpty())){
           AlertsUtil.mostrarError("Rellena todos los campos y selecciona un equipo");
    }else{
          String nombre= olequipos.get(tvequipo1.getSelectionModel().getSelectedIndex()).getNombre();
           String pais= olequipos.get(tvequipo1.getSelectionModel().getSelectedIndex()).getPais();
           
          if(!fldNombre.getText().isEmpty()){
              nombre=fldNombre.getText();
          }
           if(!fldPais.getText().isEmpty()){
              pais=fldPais.getText();
          }
      
            try{
                 adao.conectar();
           adao.modificarEquipo(fldNombre.getText(),fldPais.getText());
                olequipos.set(tvequipo1.getSelectionModel().getSelectedIndex(),
                     new Equipo(nombre,pais));
      
          }catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }
 
           }
        }
      @FXML
   private void presionado() {
    
    String nombre= olequipos.get(tvequipo1.getSelectionModel().getSelectedIndex()).getNombre();
    fldNombre.setText(nombre);
    
    String pais= olequipos.get(tvequipo1.getSelectionModel().getSelectedIndex()).getPais();
    fldPais.setText(pais); 
    }
@FXML
   private void resetear() {
      
    fldNombre.setText("");
 
    fldPais.setText("");
  
   }
}
