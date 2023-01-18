package com.mycompany.urbanizacion;

import logica.Archivos;
import logica.Permiso;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logica.*;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static String pathFiles = "src/main/resources/files/";
    //Creacion de lista 
    static ArrayList<Residente> lista_Residentes = llenarResidentes();
    static ArrayList<Colaborador> lista_colaboradores = llenarColaboradores();
    static ArrayList<Visitante> lista_Visitantes = llenarVisitantes();
    static ArrayList<Permiso> lista_permisos = llenarPermisos();
    static ArrayList<Urbanizacion> lista_urbanizaciones = llenarUrbanizaciones();
    static ArrayList<Revision> lista_Actual = new ArrayList<>();
    static ObservableList<Urbanizacion> data = null;

    @Override

  //creamos la ventana principal
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("inicio"), 640, 480);
        stage.setScene(scene);
        stage.show();
        inicializarSistemas();
    }

    static void setRoot(String fxml) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 300);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

            }
        }, 0, 1000);

    }

    /**
     * Método que carga el fxml y tira una excepción de tipo IOException
     *
     * @param fxml
     * @return
     * @throws IOException
     */
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Método estático que carga la ventana que recibe como parámetro
     *
     * @param ventana
     * @param height
     * @param width
     */
    public static void cargarVentana(String ventana, int width, int height) {
        Scene scene = null;
        try {
            scene = new Scene(loadFXML(ventana), width, height);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana donde se encuentra el elemento
        stage.close();                          //Me cierra la ventana
    }

    private void inicializarSistema() {
        data = FXCollections.observableArrayList(lista_urbanizaciones);
    }

    public static Colaborador buscarEncargado(String Cedula) {
        for (Colaborador c : lista_colaboradores) {
            if (c.getTipoEmpleado().equals(TipoEmpleado.ADMINISTRADOR) && c.getCedula().equals(Cedula) && c.getEstado().equals(Estado.ACTIVO)) {
                return c;
            }
        }
        return null;
    }

    public static Colaborador buscarGuardia(String Cedula) {
        for (Colaborador c : lista_colaboradores) {
            if (c.getTipoEmpleado().equals(TipoEmpleado.GUARDIA) && c.getCedula().equals(Cedula) && c.getEstado().equals(Estado.ACTIVO)) {
                return c;
            }
        }
        return null;
    }

    public static Visitante buscarVisitante(String Cedula) {
        for (Visitante v : lista_Visitantes) {
            if (v.getCedula().equals(Cedula)) {
                return v;
            }
        }
        return null;
    }

    public static Residente buscarResidente(String Cedula) {
        for (Residente r : lista_Residentes) {
            if (r.getCedula().equals(Cedula) && r.getEstado().equals(Estado.ACTIVO)) {
                return r;
            }
        }
        return null;
    }

    private static ArrayList<Visitante> llenarVisitantes() {
        ArrayList<String[]> lineas = Archivos.generarArreglo(pathFiles + "visitantes.txt");
        ArrayList<Visitante> visitantes = new ArrayList<>();
        for (String[] linea : lineas) {
            visitantes.add(new Visitante(linea[0], linea[1], linea[2], linea[3], linea[4], linea[5]));
        }

        return visitantes;
    }

    private static ArrayList<Urbanizacion> llenarUrbanizaciones() {
        ArrayList<String[]> lineas = Archivos.generarArreglo(pathFiles + "urbanizaciones.txt");
        ArrayList<Urbanizacion> urbanizacion = new ArrayList<>();
        for (String[] linea : lineas) {
            urbanizacion.add(new Urbanizacion(linea[0], linea[1], linea[2], linea[3], linea[4], buscarEncargado(linea[5])));
        }

        return urbanizacion;
    }

    private static ArrayList<Residente> llenarResidentes() {
        ArrayList<String[]> lineas = Archivos.generarArreglo(pathFiles + "residentes.txt");
        ArrayList<Residente> residente = new ArrayList<>();
        for (String[] linea : lineas) {
            residente.add(new Residente(linea[0], linea[1], linea[2], linea[3], linea[4], linea[5], Estado.valueOf(linea[6])));
        }

        return residente;
    }

    private static ArrayList<Colaborador> llenarColaboradores() {
        ArrayList<String[]> lineas = Archivos.generarArreglo(pathFiles + "colaboradores.txt");
        ArrayList<Colaborador> colaborador = new ArrayList<>();
        for (String[] linea : lineas) {
            colaborador.add(new Colaborador(linea[0], linea[1], TipoEmpleado.valueOf(linea[2]), Estado.valueOf(linea[3]), linea[4], linea[5], linea[6], linea[7], linea[8]));
        }

        return colaborador;
    }

    public static ArrayList<Permiso> llenarPermisos() {
        ArrayList<String[]> lineas = Archivos.generarArreglo(pathFiles + "permisos.txt");
        ArrayList<Permiso> permisos = new ArrayList<>();
        for (String[] linea : lineas) {
            Residente residente = buscarResidente(linea[1]);
            Visitante visitantePermitido = buscarVisitante(linea[2]);
            permisos.add(new Permiso(linea[0], residente, visitantePermitido, linea[3], linea[4], linea[5], linea[6], EstadoPermiso.valueOf(linea[7])));
        }

        return permisos;
    }

    public static ArrayList<Permiso> buscarPermisos(String Cedula) {
        ArrayList<Permiso> permisos = new ArrayList<>();
        for (Permiso p : lista_permisos) {
            if (p.getResidente().getCedula().equals(Cedula)) {
                permisos.add(p);
            }
        }
        return permisos;
    }

    public static ArrayList<Permiso> buscarPermisos(String manzana, String villa) {
        ArrayList<Permiso> permisos = new ArrayList<>();
        for (Permiso p : lista_permisos) {
            if (p.getResidente().getMz().equals(manzana) && p.getResidente().getVilla().equals(villa)) {
                permisos.add(p);
            }
        }
        return permisos;
    }

    public static ArrayList<Permiso> buscarPermisosActivos(String Cedula) {
        ArrayList<Permiso> permisos = buscarPermisos(Cedula);
        ArrayList<Permiso> permisosActivos = new ArrayList<>();

        for (Permiso p : permisos) {
            if (p.getResultado().equals(EstadoPermiso.ACTIVO)) {
                permisosActivos.add(p);
            }
        }
        return permisosActivos;
    }

    public static void actualizarPermiso(Permiso permiso, EstadoPermiso estado) {
        for (Permiso p : App.lista_permisos) {
            if (p.getCodigoPermiso().equals(permiso.getCodigoPermiso())) {
                p.setResultado(estado);
            }
        }
        String lineSeparator = System.lineSeparator();

        String mensaje = "fechaHora,cedulaResidente,cedulaVisitantePermitido,fechaIngreso,horaIngreso,duracion,codigoVisitante,estadoPermiso" + lineSeparator;

        for (Permiso p : App.lista_permisos) {
            String permisoString = p.getfechaHora() + "," + p.getResidente().getCedula() + "," + p.getVisitantePermitido().getCedula() + "," + p.getFechaIngreso() + "," + p.getHoraIngreso() + "," + p.getDuracion() + "," + p.getCodigoPermiso() + "," + String.valueOf(p.getResultado() + lineSeparator);
            mensaje += permisoString;
        }
        mensaje = mensaje.trim();

        Archivos.actualizarArchivo(App.pathFiles + "permisos.txt", mensaje);
    }

}
