module com.mycompany.urbanizacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.urbanizacion to javafx.fxml;
    exports com.mycompany.urbanizacion;
}
