package com.mycompany.deportista1;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void switchToEquipo() throws IOException {
        App.setRoot("Equipo");
    }
}
