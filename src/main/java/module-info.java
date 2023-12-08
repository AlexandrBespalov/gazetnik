module com.example.gazetnik {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.gazetnik.ui;
    exports com.example.gazetnik;
}