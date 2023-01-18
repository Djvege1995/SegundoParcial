/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.urbanizacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logica.Colaborador;
import logica.Urbanizacion;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class FormularioUrbanizacionController implements Initializable {

    @FXML
    TextField txtNombre;
    @FXML
    TextField txtEtapa;
    @FXML
    TextField txtEmail;
    @FXML
    TextField txtDireccion;
    @FXML
    TextField txtConstructora;
    @FXML
    TextField txtCedula;
    @FXML
    Label lblInfo;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void cancelar(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("menuUrbanizacion", 640, 310);
    }

    @FXML
    public void aceptar(ActionEvent event) {
        String nombre = App.data.get(MenuUrbanizacionController.indiceSeleccionado).getNombre();
        String etapa = App.data.get(MenuUrbanizacionController.indiceSeleccionado).getEtapa();
        String email = App.data.get(MenuUrbanizacionController.indiceSeleccionado).getEmailAdministrador();
        String direccion = App.data.get(MenuUrbanizacionController.indiceSeleccionado).getDireccion();
        String constructora = App.data.get(MenuUrbanizacionController.indiceSeleccionado).getConstructora();
        Colaborador encargado = App.data.get(MenuUrbanizacionController.indiceSeleccionado).getPersonaResponsable();

        if (!txtNombre.getText().isBlank()) {
            nombre = txtNombre.getText();
        }
        if (!txtEtapa.getText().isBlank()) {
            etapa = txtEtapa.getText();
        }
        if (!txtEmail.getText().isBlank()) {
            email = txtEmail.getText();
        }
        if (!txtDireccion.getText().isBlank()) {
            direccion = txtDireccion.getText();
        }
        if (!txtConstructora.getText().isBlank()) {
            constructora = txtConstructora.getText();
        }
        if (!txtCedula.getText().isBlank()) {
            String cedula = txtCedula.getText();
            encargado=App.buscarEncargado(cedula);
        }
        if(encargado!=null){
            App.data.set(MenuUrbanizacionController.indiceSeleccionado, new Urbanizacion(nombre,etapa,email,direccion,constructora,encargado));
            App.cerrarVentana(event);
        }else{
            lblInfo.setText("No existe un administrador activo con esa cedula");
        }
        
    }

}
