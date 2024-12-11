module com.tarea01u2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tarea01u2 to javafx.fxml;
    exports com.tarea01u2;
}