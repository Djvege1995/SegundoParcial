/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.urbanizacion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import logica.*;

/**
 *
 * @author Michael
 */
public class UrbanizacionTableView extends TableView<Urbanizacion> {
    
    public UrbanizacionTableView() {
        // Crear columnas
        TableColumn<Urbanizacion, String> nombreColumn = new TableColumn<>("Nombre");
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        nombreColumn.setPrefWidth(100);

        TableColumn<Urbanizacion, String> etapaColumn = new TableColumn<>("Etapa");
        etapaColumn.setCellValueFactory(cellData -> cellData.getValue().etapaProperty());
        etapaColumn.setPrefWidth(100);

        TableColumn<Urbanizacion, String> emailColumn = new TableColumn<>("Email Administrador");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailAdministradorProperty());
        emailColumn.setPrefWidth(100);

        TableColumn<Urbanizacion, String> direccionColumn = new TableColumn<>("Dirección");
        direccionColumn.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
        direccionColumn.setPrefWidth(100);

        TableColumn<Urbanizacion, String> constructoraColumn = new TableColumn<>("Constructora");
        constructoraColumn.setCellValueFactory(cellData -> cellData.getValue().constructoraProperty());
        constructoraColumn.setPrefWidth(100);
        TableColumn<Urbanizacion, String> personaResponsableColumn = new TableColumn<>("Persona Responsable");
        personaResponsableColumn.setCellValueFactory(cellData -> cellData.getValue().personaResponsableProperty().nombreProperty());
        personaResponsableColumn.setPrefWidth(150);

        // Añadir columnas a la tabla
        this.getColumns().addAll(nombreColumn, etapaColumn, emailColumn, direccionColumn, constructoraColumn, personaResponsableColumn);

        // Crear datos de prueba        
        this.setItems(App.data);

    }
}
|