module com.example.gkiosk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gazetnik to javafx.fxml;
    exports com.example.gazetnik;
}