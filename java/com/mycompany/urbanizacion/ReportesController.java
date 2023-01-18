/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.urbanizacion;

import static com.mycompany.urbanizacion.MenuPermisosController.tblPermisos;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import logica.Permiso;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class ReportesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField txtCedula;
    @FXML
    TableView tvReporte;
    @FXML
    Label lblInfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void regresar(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("menu", 600, 400);
    }

    @FXML
    public void buscar(ActionEvent event) {
        if (!txtCedula.getText().isBlank()) {
            ArrayList<Permiso> permisos = App.buscarPermisos(txtCedula.getText());
            if (!permisos.isEmpty()) {
                TableColumn<Permiso, String> colAtributo1 = new TableColumn<>("Codigo Permiso");
                colAtributo1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCodigoPermiso()));
                TableColumn<Permiso, String> colAtributo2 = new TableColumn<>("Estado");
                colAtributo2.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getResultado())));
                TableColumn<Permiso, String> colAtributo3 = new TableColumn<>("Visitante");
                colAtributo3.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getVisitantePermitido().getCedula()));
                TableColumn<Permiso, String> colAtributo4 = new TableColumn<>("Observación");
                colAtributo4.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getObservacion()));
                tvReporte.getColumns().addAll(colAtributo1,colAtributo2,colAtributo3,colAtributo4);
                tvReporte.setItems(FXCollections.observableList(permisos));
                tvReporte.refresh();
            }else{
                lblInfo.setText("No ha creado permisos");
            }
        }

    }

}
