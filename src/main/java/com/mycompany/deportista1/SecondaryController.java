package com.mycompany.deportista1;

import com.mycompany.DAO.DeportistaDAO;
import com.mycompany.models.Deportista;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController {
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
    private TableColumn<Deportista,String> colNombre;
  @FXML
    private TableView<Deportista> tvdeportista= new TableView<>();
     
    
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
            tvdeportista=adao.verDeportistas();
            colFecha.setCellValueFactory(new PropertyValueFactory<Deportista,Date>("fecha_nacimiento"));
             colDorsal.setCellValueFactory(new PropertyValueFactory<Deportista,Integer>("dorsal"));
             colAltura.setCellValueFactory(new PropertyValueFactory<Deportista,Integer>("altura"));
             colNombre.setCellValueFactory(new PropertyValueFactory<Deportista,String>("nombre"));
             colNacionalidad.setCellValueFactory(new PropertyValueFactory<Deportista,String>("nacionalidad"));
             colEquipo.setCellValueFactory(new PropertyValueFactory<Deportista,String>("equipo"));
             colDeporte.setCellValueFactory(new PropertyValueFactory<Deportista,String>("deporte_jugado"));
        } catch (ClassNotFoundException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        } catch (SQLException ex) {
             AlertsUtil.mostrarError(ex.getMessage());
        }
    }
}