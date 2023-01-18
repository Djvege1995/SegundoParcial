/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.urbanizacion;

import logica.Permiso;
import static com.mycompany.urbanizacion.MenuPermisosController.tblPermisos;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logica.EstadoPermiso;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class MenuRevisionController implements Initializable {

    @FXML
    TextField txtCedula;
    @FXML
    Label lblInfo;
    public static Permiso permiso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (Permiso p : App.lista_permisos) {
            String fechaIngreso = p.getFechaIngreso();
            LocalDate fecha = LocalDate.parse(fechaIngreso, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String horaIngreso = p.getHoraIngreso();
            LocalTime hora = LocalTime.parse(horaIngreso);
            LocalDateTime fechaHoraIngreso = hora.atDate(fecha);
            LocalDateTime fechaHoraIngresoMenos15 = fechaHoraIngreso.minusMinutes(15);
            LocalDateTime fechaHoraIngresoMas15 = fechaHoraIngreso.plusMinutes(15);
            LocalDateTime fechaHoraActual = LocalDateTime.now();

            if (fechaHoraActual.isBefore(fechaHoraIngresoMenos15) || fechaHoraActual.isAfter(fechaHoraIngresoMas15)) {            
                App.actualizarPermiso(p,EstadoPermiso.CADUCADO);
            }
        }
        revisarPermiso();
    }

    @FXML
    public void cancelar(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("menu", 600, 400);
    }

    private void revisarPermiso() {
        txtCedula.setOnAction(event -> {
            // Acciones a realizar cuando se presiona la tecla "Enter"
            if (!txtCedula.getText().isBlank()) {
                String codigo = txtCedula.getText();
                for (Permiso p : App.lista_permisos) {
                    if (p.getCodigoPermiso().equals(codigo)) {
                        permiso = p;
                    }
                }
                if (permiso != null) {
                    if (permiso.getResultado().equals(EstadoPermiso.ACTIVO)) {
                        App.cerrarVentana(event);
                        App.cargarVentana("revision", 420, 680);

                    } else {
                        lblInfo.setText("Su permiso tiene estado: " + permiso.getResultado());
                    }
                } else {
                    lblInfo.setText("No existe un permiso con ese codigo");
                }
            }
        });

    }
}
