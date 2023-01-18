/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Michael
 */
public class Colaborador extends Persona {

    private final SimpleStringProperty fechainicio;
    private final SimpleStringProperty fechafin;
    private final TipoEmpleado tipoEmpleado;
    private final Estado estado;
    private final SimpleStringProperty puestoTrabajo;
    private final SimpleStringProperty cedula;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty telefono;
    private final SimpleStringProperty email;

    public Colaborador(String fechainicio, String fechafin, TipoEmpleado tipoEmpleado, Estado estado, String puestoTrabajo, String cedula, String nombre, String telefono, String email) {
        super(cedula, nombre, telefono, email);

        this.fechainicio = new SimpleStringProperty(fechainicio);
        this.fechafin = new SimpleStringProperty(fechafin);
        this.tipoEmpleado = tipoEmpleado;
        this.estado = estado;
        this.puestoTrabajo = new SimpleStringProperty(puestoTrabajo);
        this.cedula = new SimpleStringProperty(cedula);
        this.nombre = new SimpleStringProperty(nombre);
        this.telefono = new SimpleStringProperty(telefono);
        this.email = new SimpleStringProperty(email);
    }

    public String getFechainicio() {
        return fechainicio.get();
    }

    public SimpleStringProperty fechainicioProperty() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio.set(fechainicio);
    }

    public String getFechafin() {
        return fechafin.get();
    }

    public SimpleStringProperty fechafinProperty() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin.set(fechafin);
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo.get();
    }

    public SimpleStringProperty puestoTrabajoProperty() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo.set(puestoTrabajo);
    }

    public String getCedula() {
        return cedula.get();
    }

    public SimpleStringProperty cedulaProperty() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula.set(cedula);
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getTelefono() {
        return telefono.get();
    }

    public SimpleStringProperty telefonoProperty() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono.set(telefono);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public static void informacionEmpleado(ArrayList<Colaborador> lista_Colaboradores) {
        System.out.println("Informacion de los empleados");
        for (Colaborador c : lista_Colaboradores) {
            System.out.println(c);
        }

    }

    @Override
    public String toString() {
        System.out.println("----------Colaborador--------------");
        return "fecha inicio  " + fechainicio + "\nfecha fin " + fechafin + "\ntipoEmpleado " + tipoEmpleado + "\nestado " + estado + "\npuestoTrabajo " + puestoTrabajo;

    }

}
