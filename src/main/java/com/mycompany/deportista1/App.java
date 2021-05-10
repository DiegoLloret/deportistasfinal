package com.mycompany.deportista1;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
  @FXML
    private ImageView imagen;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        String fxml = "primary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        scene = new Scene(fxmlLoader.load(), 1090, 590);
       // scene = new Scene(loadFXML("primary"), 1090, 590);
        stage.setScene(scene);
        
        stage.show();
        //PrimaryController controller = new PrimaryController();
      //  PrimaryController controller = fxmlLoader.getController();
       // controller.loadImage();
       //scene.setRoot(fxmlLoader.load());
       
    }

    static void setRoot(String fxml) throws IOException {
      scene.setRoot(loadFXML(fxml));
       
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}