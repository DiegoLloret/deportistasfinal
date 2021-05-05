package com.mycompany.deportista1;

import com.mycompany.deportista1.DAO.DeportistaDAO;
import com.mycompany.deportista1.models.Deportista;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController {
    @FXML private TableView<Deportista> tvdeportista1;
  
    
    @FXML
    private TableColumn<Deportista,Date> colFecha;

    @FXML
    private TableColumn<Deportista,Integer> colDorsal;

    @FXML
    private TableColumn<Deportista,String> colDeporte;

    @FXML
    private TableColumn<Deportista,String> colNacionalidad;

    @FXML
    private TableColumn<Deportista, Integer> colAltura;

    @FXML
    private TableColumn<Deportista,String> colEquipo;

    @FXML
    private Button volver;
    @FXML
    private Button actualizar;
    @FXML
    private Button eliminar;
    @FXML
    private TableColumn<Deportista,String> colNombre;
    @FXML
    private  ObservableList<Deportista> oldeportistas;
    // campos insert
    @FXML
    private TextField fldEquipo;
    @FXML
    private TextField fldDeporte;
     @FXML
    private TextField fldDorsal;
    @FXML
    private DatePicker fldFecha;
     @FXML
    private TextField fldNacionalidad;
    @FXML
    private TextField fldNombre;
    @FXML
    private TextField fldAltura;
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
     @FXML
    private void showDeportista() throws IOException, SQLException {
        DeportistaDAO adao =new DeportistaDAO();
       
        try {
            adao.conectar();
           // AlertsUtil.mostrarInfo("Conexion sin errores");
            oldeportistas= FXCollections.observableArrayList();
               adao.verDeportistas(oldeportistas);
           System.out.println("size: "+oldeportistas.size());
           // tvdeportista1=adao.verDeportistas();
            // tvdeportista1.getColumns().addAll(colNombre,colFecha,colAltura,colNacionalidad,colDorsal,colDeporte,colEquipo);
            System.out.println("paso0 por tvdeportista1");
            //tvdeportista1 = new  TableView<Deportista>();
            tvdeportista1.setItems(oldeportistas);
            colNombre.setCellValueFactory(new PropertyValueFactory<Deportista,String>("nombre"));
            colFecha.setCellValueFactory(new PropertyValueFactory<Deportista,Date>("fecha_nacimiento"));
            colAltura.setCellValueFactory(new PropertyValueFactory<Deportista,Integer>("altura"));
            colNacionalidad.setCellValueFactory(new PropertyValueFactory<Deportista,String>("nacionalidad"));
             colDorsal.setCellValueFactory(new PropertyValueFactory<Deportista,Integer>("dorsal"));
             colDeporte.setCellValueFactory(new PropertyValueFactory<Deportista,String>("deporte_jugado"));
             colEquipo.setCellValueFactory(new PropertyValueFactory<Deportista,String>("equipo"));
            System.out.println("paso por tvdeportista1");
             //tvdeportista1.getColumns().addAll(colNombre);
              System.out.println("paso2 por tvdeportista1");
        } catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }
    }
   @FXML
    private void AddDeportista()throws IOException, SQLException {
       DeportistaDAO adao =new DeportistaDAO();
 
       
        if(fldNombre.getText().isEmpty()||fldNacionalidad.getText().isEmpty()|| fldDorsal.getText().isEmpty()|| fldEquipo.getText().isEmpty()||fldDeporte.getText().isEmpty()||fldAltura.getText().isEmpty()){
           AlertsUtil.mostrarError("Rellena todos los campos");
        }else{
        
             Deportista d = new Deportista(
                     fldNombre.getText(),
                         Date.valueOf(fldFecha.getValue()),
                        Integer.parseInt(fldAltura.getText()),
                        fldNacionalidad.getText(),
                        Integer.parseInt(fldDorsal.getText()),
                        fldDeporte.getText(),
                        fldEquipo.getText());
           
          try{
            adao.conectar();
           adao.insertarDeportista(fldNombre.getText(),Date.valueOf(fldFecha.getValue()),Integer.parseInt(fldAltura.getText()),fldNacionalidad.getText(),Integer.parseInt(fldDorsal.getText()),fldDeporte.getText(),fldEquipo.getText());
         oldeportistas.add(d);
      
          }catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }

        }
       
            }
    @FXML
    private void  borrarDeportista()throws IOException, SQLException {
        DeportistaDAO adao =new DeportistaDAO();
        if(tvdeportista1.getSelectionModel().isEmpty()){
            AlertsUtil.mostrarError("Selecciona un jugador");
        }else{
           
             try{
            adao.conectar();
           adao.deleteDeportista(tvdeportista1.getSelectionModel().getSelectedItem().getNombre());
           oldeportistas.remove(tvdeportista1.getSelectionModel().getSelectedItem());
          }catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }
            
        }
    }
}
