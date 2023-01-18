/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.urbanizacion;

import logica.Archivos;
import logica.Permiso;
import static com.mycompany.urbanizacion.App.buscarPermisos;
import static com.mycompany.urbanizacion.MenuUrbanizacionController.indiceSeleccionado;
import static com.mycompany.urbanizacion.MenuUrbanizacionController.tableView;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logica.EstadoPermiso;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class MenuPermisosController implements Initializable {

    static TableView<Permiso> tblPermisos = new TableView<>();
    static String cedula = "";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void crearPermiso(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("creacionPermiso", 400, 430);
    }

    @FXML
    public void eliminarPermiso(ActionEvent event) {
        App.cerrarVentana(event);
        Label lblInfo = new Label();
        Label lblCedula = new Label("Ingrese su cedula: ");
        TextField txtCedula = new TextField();
        HBox datos = new HBox();
        datos.setAlignment(Pos.CENTER);
        datos.setSpacing(10);
        Button btnBuscar = new Button("Buscar");
        datos.getChildren().addAll(lblCedula, txtCedula, btnBuscar);
        btnBuscar.setOnAction(e -> {
            cedula = txtCedula.getText();

            // Buscar permisos del residente
            List<Permiso> permisos = App.buscarPermisosActivos(cedula);
            if (!permisos.isEmpty()) {
                // Mostrar permisos en la tabla
                mostrarPermisos(permisos);
            } else {
                lblInfo.setText("No tiene permisos activos");
            }

        });
        // Crear columna "Fecha y hora"
        TableColumn<Permiso, String> colFechaHora = new TableColumn<>("Fecha y hora");
        colFechaHora.setCellValueFactory(new PropertyValueFactory<>("fechaHora"));
        colFechaHora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getfechaHora()));
        colFechaHora.setPrefWidth(150);

        // Crear columna "Visitante permitido"
        TableColumn<Permiso, String> colVisitante = new TableColumn<>("Visitante permitido");
        colVisitante.setCellValueFactory(new PropertyValueFactory<>("visitantePermitido"));
        colVisitante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVisitantePermitido().getCedula()));
        colVisitante.setPrefWidth(150);

        // Crear columna "Fecha de ingreso"
        TableColumn<Permiso, String> colFechaIngreso = new TableColumn<>("Fecha de ingreso");
        colFechaIngreso.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFechaIngreso()));
        colFechaIngreso.setPrefWidth(150);

        // Crear columna "Hora de ingreso"
        TableColumn<Permiso, String> colHoraIngreso = new TableColumn<>("Hora de ingreso");
        colHoraIngreso.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHoraIngreso()));
        colHoraIngreso.setPrefWidth(150);

        // Crear columna "Duración"
        TableColumn<Permiso, String> colDuracion = new TableColumn<>("Duración");
        colDuracion.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDuracion()));
        colDuracion.setPrefWidth(100);

        // Crear columna "Código de permiso"
        TableColumn<Permiso, String> colCodigo = new TableColumn<>("Código de permiso");
        colCodigo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCodigoPermiso()));
        colCodigo.setPrefWidth(150);

        // Crear columna "Estado"
        TableColumn<Permiso, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getResultado())));
        colEstado.setPrefWidth(100);

        // Añadir columnas a la tabla
        tblPermisos.getColumns().addAll(colFechaHora, colVisitante, colFechaIngreso, colHoraIngreso, colDuracion, colCodigo, colEstado);
        // Crear botón para eliminar permisos
        Button btnEliminar = new Button("Eliminar");
        Button btnRegresar = new Button("Regresar");
        btnRegresar.setOnAction(e -> {
            App.cerrarVentana(e);
            App.cargarVentana("menu", 600, 400);
        });
        HBox botones = new HBox();
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(20);
        botones.getChildren().addAll(btnEliminar, btnRegresar);
        btnEliminar.setOnAction(e -> {
            // Obtener permiso seleccionado
            if (!tblPermisos.getSelectionModel().isEmpty()) {
                lblInfo.setText("");
                Permiso permiso = tblPermisos.getSelectionModel().getSelectedItem();
                // Actualizar permiso en la base de datos o archivo
                if (permiso.getResultado().equals(EstadoPermiso.USADO)) {
                    lblInfo.setText("No se puede eliminar un permiso ya usado");
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmar Eliminación");
                    alert.setHeaderText("¿Está seguro de que desea eliminar el permiso seleccionado?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        App.actualizarPermiso(permiso, EstadoPermiso.INACTIVO);
                        // Actualizar tabla
                        actualizarTabla();

                    }

                }

            } else {
                lblInfo.setText("Seleccione un item de la tabla");
            }

        });

        VBox root = new VBox();
        root.setStyle("-fx-padding: 20px;");
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(datos, tblPermisos, lblInfo, botones);
        // Crea la escena y asigna el nodo raíz como contenido
        Scene scene = new Scene(root, 1000, 300);
        Stage stage = new Stage();
// Asigna la escena al stage
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML

    public void consultarPermiso(ActionEvent event) {
        App.cerrarVentana(event);
        Label lblInfo = new Label();
        TextField txtManzanaVilla = new TextField();
        TextField txtVilla = new TextField();
        HBox hboxDatos = new HBox();
        Button btnBuscar = new Button("Buscar");
        hboxDatos.getChildren().addAll(txtManzanaVilla, txtVilla, btnBuscar);
        btnBuscar.setOnAction(e -> {
            String manzana = txtManzanaVilla.getText();
            String villa = txtVilla.getText();

            // Buscar permisos del residente
            List<Permiso> permisos = App.buscarPermisos(manzana, villa);
            Collections.sort(permisos);
            if (!permisos.isEmpty()) {
                lblInfo.setText("");
                // Mostrar permisos en la tabla
                mostrarPermisos(permisos);
            } else {
                lblInfo.setText("No tiene permisos");
            }

        });
        // Crear columna "Fecha y hora"
        TableColumn<Permiso, String> colFechaHora = new TableColumn<>("Fecha y hora");
        colFechaHora.setCellValueFactory(new PropertyValueFactory<>("fechaHora"));
        colFechaHora.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getfechaHora()));
        colFechaHora.setPrefWidth(150);

        // Crear columna "Visitante permitido"
        TableColumn<Permiso, String> colVisitante = new TableColumn<>("Visitante permitido");
        colVisitante.setCellValueFactory(new PropertyValueFactory<>("visitantePermitido"));
        colVisitante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVisitantePermitido().getCedula()));
        colVisitante.setPrefWidth(150);

        // Crear columna "Fecha de ingreso"
        TableColumn<Permiso, String> colFechaIngreso = new TableColumn<>("Fecha de ingreso");
        colFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        colFechaIngreso.setPrefWidth(150);

        // Crear columna "Hora de ingreso"
        TableColumn<Permiso, String> colHoraIngreso = new TableColumn<>("Hora de ingreso");
        colHoraIngreso.setCellValueFactory(new PropertyValueFactory<>("horaIngreso"));
        colHoraIngreso.setPrefWidth(150);

        // Crear columna "Duración"
        TableColumn<Permiso, String> colDuracion = new TableColumn<>("Duración");
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        colDuracion.setPrefWidth(100);

        // Crear columna "Código de permiso"
        TableColumn<Permiso, String> colCodigo = new TableColumn<>("Código de permiso");
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigoPermiso"));
        colCodigo.setPrefWidth(150);

        // Crear columna "Estado"
        TableColumn<Permiso, EstadoPermiso> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("resultado"));
        colEstado.setPrefWidth(100);

        // Añadir columnas a la tabla
        tblPermisos.getColumns().addAll(colFechaHora, colVisitante, colFechaIngreso, colHoraIngreso, colDuracion, colCodigo, colEstado);

        VBox root = new VBox();
        root.getChildren().addAll(hboxDatos, tblPermisos, lblInfo);
        // Crea la escena y asigna el nodo raíz como contenido
        Scene scene = new Scene(root, 950, 300);
        Stage stage = new Stage();
// Asigna la escena al stage
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void regresar(ActionEvent event) {
        App.cerrarVentana(event);
        App.cargarVentana("menu", 600, 400);
    }

    private void mostrarPermisos(List<Permiso> permisos) {
        tblPermisos.getItems().clear();

        // Añadir permisos a la tabla
        tblPermisos.getItems().addAll(permisos);
    }

    private void actualizarTabla() {
        // Obtén los datos más recientes
        App.lista_permisos = App.llenarPermisos();
        List<Permiso> datosRecientes = App.buscarPermisosActivos(cedula);

        // Limpia cualquier dato anterior de la tabla
        tblPermisos.getItems().clear();

        // Añade los nuevos datos a la tabla
        tblPermisos.getItems().addAll(datosRecientes);

        // Actualiza la tabla
        tblPermisos.refresh();
    }
}
