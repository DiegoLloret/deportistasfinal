package com.mycompany.deportista1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {
    @FXML
    private MenuItem btnir1;
    @FXML
    private MenuItem btnir2;
    @FXML
    private MenuItem btnir;
      @FXML
    private ImageView imagen;
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void switchToEquipo() throws IOException {
        App.setRoot("Equipo");
    }
      @FXML
    private void switchToDeporte() throws IOException {
        App.setRoot("Deporte");
}
     public void loadImage(){
         try{
             System.out.println(this.getClass().getResource("/images/imagen.png"));
      
       Image img =new Image("/images/imagen.png");
        imagen.setImage(img);}
         catch(Exception e)
         {System.out.println("estrreeeeeeeeereeeeeeeeeerrrrrrrrrrrrrrrrrrrrrrr");
         e.printStackTrace();}
    }
}