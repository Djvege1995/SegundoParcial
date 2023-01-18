/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.urbanizacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import logica.Colaborador;
import logica.Estado;
import logica.TipoEmpleado;
import logica.Urbanizacion;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class MenuUrbanizacionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML    
    VBox contenedorTable;
    @FXML
    Label lblInfo;
    
    static UrbanizacionTableView tableView = new UrbanizacionTableView();
    static int indiceSeleccionado;    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        contenedorTable.getChildren().add(tableView);
        
    }    

    @FXML
    public void regresarMenu(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("menu", 600, 400);
    }

    @FXML
    public void editarUrbanizacion(ActionEvent event) {
        if (!tableView.getSelectionModel().isEmpty()) {
            lblInfo.setText("");
            indiceSeleccionado = tableView.getSelectionModel().getSelectedIndex();
            App.cargarVentana("formularioUrbanizacion", 700, 644);
        } else {
            lblInfo.setText("Seleccione un item de la tabla");
        }
        
    }
}
