/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class Revision {

    private Permiso permisoCreado;
    private String Observacion;
    private TipoEmpleado trabajador;
    private EstadoPermiso permisoactual;

    public Revision(Permiso permisoCreado, String Observacion, TipoEmpleado trabajador, EstadoPermiso permisoactual) {
        this.permisoCreado = permisoCreado;
        this.Observacion = Observacion;
        this.trabajador = trabajador;
        this.permisoactual = permisoactual;
    }

    public Permiso getPermisoCreado() {
        return permisoCreado;
    }

    public void setPermisoCreado(Permiso permisoCreado) {
        this.permisoCreado = permisoCreado;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public TipoEmpleado getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TipoEmpleado trabajador) {
        this.trabajador = trabajador;
    }

    public EstadoPermiso getPermisoactual() {
        return permisoactual;
    }

    public void setPermisoactual(EstadoPermiso permisoactual) {
        this.permisoactual = permisoactual;
    }

   

    @Override
    public String toString() {
        return "permisoCreado/n " + permisoCreado + "/nObservacion  " + Observacion + " /ntrabajador " + trabajador + "/npermisoactual " + permisoactual;
    }
}
