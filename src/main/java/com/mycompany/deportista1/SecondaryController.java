package com.mycompany.deportista1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class SecondaryController {
  @FXML
    private TableView<?> tvdeportista;

    @FXML
    private Button volver;
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}