/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.urbanizacion;

import logica.Archivos;
import logica.Permiso;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logica.EstadoPermiso;
import logica.Residente;
import logica.Visitante;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class CreacionPermisoController implements Initializable {

    @FXML
    Label lblInfo;
    @FXML
    TextField txtResidente;
    @FXML
    TextField txtVisitante;
    @FXML
    DatePicker fecha;
    @FXML
    TextField txtHora;
    @FXML
    TextField txtDuracion;

    /**
     *
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void cancelar(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("menuPermisos", 600, 400);
    }

    @FXML
    public void crearPermiso(ActionEvent event) {
        if (!(txtResidente.getText().isBlank()) && !(txtVisitante.getText().isBlank()) && fecha.getValue() != null && !(txtHora.getText().isBlank()) && !(txtDuracion.getText().isBlank())) {
            Visitante visitante = App.buscarVisitante(txtVisitante.getText());
            Residente residente = App.buscarResidente(txtResidente.getText());
            LocalDate fechaSeleccionada = fecha.getValue();
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaIngresada = LocalTime.parse(txtHora.getText(), formateador);
            LocalTime duration = LocalTime.parse(txtDuracion.getText(), formateador);
            String durationString = duration.toString();
            String fechaString = fechaSeleccionada.toString();
            String horaString = horaIngresada.toString();
            if ((visitante != null && residente != null)) {
                LocalDate fechaActual = LocalDate.now();
                if (!fechaSeleccionada.isAfter(fechaActual.plusDays(1))&&visitante.getHistorial().equals("Sin sancion")) {
                    LocalDateTime fechaHoraActual = LocalDateTime.now();
                    DateTimeFormatter formateador1 = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss.SSS");
                    String fechaHoraActualString = fechaHoraActual.format(formateador1);
                    String codigo = Permiso.crearCodigo();
                    Permiso permiso=new Permiso(fechaHoraActualString, residente, visitante, fechaString, horaString, durationString, codigo, EstadoPermiso.ACTIVO);                 
                    String mensaje=permiso.getfechaHora()+","+permiso.getResidente().getCedula()+","+permiso.getVisitantePermitido().getCedula()+","+permiso.getFechaIngreso()+","+permiso.getHoraIngreso()+","+permiso.getDuracion()+","+permiso.getCodigoPermiso()+","+String.valueOf(permiso.getResultado());
                    Archivos.escribirArchivo(App.pathFiles+"permisos.txt", mensaje);
                    App.lista_permisos = App.llenarPermisos();
                    App.cerrarVentana(event);
                    App.cargarVentana("menuPermisos", 640, 310);
                }

            }
            if (visitante == null && residente == null) {
                lblInfo.setText("No se encuentra un visitante y residente con esa cedula");
            } else if (residente == null) {
                lblInfo.setText("No se encuentra un visitante con esa cedula");
            } else if (visitante == null ) {
                lblInfo.setText("No se encuentra un visitante con esa cedula");
            }

        }

    }
}
