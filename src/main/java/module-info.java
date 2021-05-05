module com.mycompany.deportista1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;      
    opens com.mycompany.deportista1 to javafx.fxml;
    exports com.mycompany.deportista1;
    opens com.mycompany.deportista1.models to javafx.fxml;
    exports com.mycompany.deportista1.models;
}
