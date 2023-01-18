/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.urbanizacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void abrirUrbanizacion(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("menuUrbanizacion", 650, 400);
    }
    @FXML
    public void abrirPermisos(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("menuPermisos", 640, 620);
    }
    @FXML
    public void abrirRevision(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("menuRevision", 412, 443);
    }
    @FXML
    public void abrirReportes(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("reportes", 602, 403);
    }
    @FXML
    public void salir(ActionEvent event) {
       Platform.exit();
    }
}
