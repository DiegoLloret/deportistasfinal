package com.mycompany.deportista1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class PrimaryController {
 @FXML
    private MenuItem btnir1;

    @FXML
    private MenuItem btnir;
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void switchToEquipo() throws IOException {
        App.setRoot("Equipo");
    }
}
