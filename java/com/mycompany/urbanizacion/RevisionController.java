/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.urbanizacion;

import static com.mycompany.urbanizacion.App.lista_permisos;
import static com.mycompany.urbanizacion.MenuRevisionController.permiso;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logica.Archivos;
import logica.Colaborador;
import logica.EstadoPermiso;
import logica.Permiso;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class RevisionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField txtFecha;
    @FXML
    TextField txtCedulaResidente;
    @FXML
    TextField txtCedulaVisitante;
    @FXML
    TextField txtFechaIngreso;
    @FXML
    TextField txtHoraIngreso;
    @FXML
    TextField txtDuracion;
    @FXML
    TextField txtCodigo;
    @FXML
    TextField txtEstado;
    @FXML
    TextField txtCedulaGuardia;
    @FXML
    TextField txtObservaciones;
    @FXML
    Label lblInfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Permiso permiso = MenuRevisionController.permiso;
        txtFecha.setText(permiso.getfechaHora());
        txtCedulaResidente.setText(permiso.getResidente().getCedula());
        txtCedulaVisitante.setText(permiso.getVisitantePermitido().getCedula());
        txtFechaIngreso.setText(permiso.getFechaIngreso());
        txtHoraIngreso.setText(permiso.getHoraIngreso());
        txtDuracion.setText(permiso.getDuracion());
        txtCodigo.setText(permiso.getCodigoPermiso());
        txtEstado.setText(String.valueOf(permiso.getResultado()));
        

        // TODO
    }

    @FXML
    public void aceptar(ActionEvent event) {
        if (!txtCedulaGuardia.getText().isBlank() && !txtObservaciones.getText().isBlank()) {
            Permiso permiso = MenuRevisionController.permiso;
            Colaborador guardia = App.buscarGuardia(txtCedulaGuardia.getText());
            if (guardia != null) {
                for (Permiso p : App.lista_permisos) {
                    if (p.getCodigoPermiso().equals(permiso.getCodigoPermiso())) {
                        p.setResultado(EstadoPermiso.USADO);
                        p.setGuardia(guardia);
                        p.setObservacion(txtObservaciones.getText());
                        String mensaje=permiso.getCodigoPermiso()+","+guardia.getCedula()+","+txtObservaciones.getText();
                        Archivos.escribirArchivo(App.pathFiles+"revisiones.txt", mensaje);

                    }
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mensaje de bienvenida");
                alert.setHeaderText("Bienvenido");
                alert.setContentText("Bienvenido, tenga una buena visita");
                alert.showAndWait();
                App.cerrarVentana(event);
                App.cargarVentana("menu", 400, 430);
            }

        } else {
            lblInfo.setText("LLene los campos por favor");
        }
    }

}
