/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import logica.Colaborador;
import logica.EstadoPermiso;
import logica.Residente;
import logica.Visitante;

/**
 *
 * @author Michael
 */
public class Permiso implements Comparable<Permiso> {

    public String fechaHora;
    public Residente residente;
    public Visitante visitantePermitido;
    public String fechaIngreso;
    public String horaIngreso;
    public String duracion;
    public String codigoPermiso;
    public EstadoPermiso resultado;
    public String observacion;
    public Colaborador guardia;
    

    public static int conCodigoVisitante = 0;

    public Permiso(String fechaHora, Residente residente, Visitante visitantePermitido, String fechaIngreso, String horaIngreso, String duracion, String codigoPermiso, EstadoPermiso resultado) {
        this.fechaHora = fechaHora;
        this.residente = residente;
        this.visitantePermitido = visitantePermitido;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.duracion = duracion;
        this.codigoPermiso = codigoPermiso;
        this.resultado = resultado;
        this.observacion="Ninguna";
    }

    public EstadoPermiso getResultado() {
        return resultado;
    }

    public void setResultado(EstadoPermiso resultado) {
        this.resultado = resultado;
    }

    public String getfechaHora() {
        return fechaHora;
    }

    public void setfechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Residente getResidente() {
        return residente;
    }

    public void setResidente(Residente residente) {
        this.residente = residente;
    }

    public Visitante getVisitantePermitido() {
        return visitantePermitido;
    }

    public void setVisitantePermitido(Visitante visitantePermitido) {
        this.visitantePermitido = visitantePermitido;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getCodigoPermiso() {
        return codigoPermiso;
    }

    public void setCodigoPermiso(String codigoVisitante) {
        this.codigoPermiso = codigoPermiso;
    }

    public static int getConCodigoVisitante() {
        return conCodigoVisitante;
    }

    public static void setConCodigoVisitante(int conCodigoVisitante) {
        Permiso.conCodigoVisitante = conCodigoVisitante;
    }


    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Colaborador getGuardia() {
        return guardia;
    }

    public void setGuardia(Colaborador guardia) {
        this.guardia = guardia;
    }
    

    /* Menu de permisos*/
    public static void modificarPermiso(ArrayList<Permiso> lista_Permisos, ArrayList<Visitante> lista_Visitante, ArrayList<Residente> lista_Residentes) {
        Scanner opcion = new Scanner(System.in);
        System.out.println("1. Agregar permiso");
        System.out.println("2. Eliminar permiso");
        System.out.println("3. Consultar permiso");
        System.out.println("4. Salir");
        System.out.println("Cual es su opcion: ");
        int op = opcion.nextInt();
        if (op == 1) {
            /*Agregar un permiso*/

            crearPermiso(lista_Permisos, lista_Visitante);

        }
        if (op == 2) {
            /*Eliminar un permiso*/
            System.out.println("Ingrese cedula del visitante: ");
            String cedula_ingresa = opcion.nextLine();
            opcion.nextLine();
            eliminarPermiso(lista_Permisos, cedula_ingresa);

        }
        if (op == 3) {
            /*Consultar un permiso*/
            System.out.println("Ingrese mz del residente: ");
            opcion.nextLine();
            String mz_ingresa = opcion.nextLine();
            System.out.println("Ingrese villa del residente: ");
            String villa_ingresa = opcion.nextLine();
            consultarPermiso(lista_Permisos, lista_Residentes, mz_ingresa, villa_ingresa);

        } else {
            return;

        }

    }

    public static void crearPermiso(ArrayList<Permiso> lista_Permisos, ArrayList<Visitante> lista_Visitante) {
        Scanner opcion = new Scanner(System.in);
        System.out.println("Ingrese la fecha (DD/MM/AAAA): ");
        String fechaPermiso = opcion.nextLine();
        System.out.println("Ingrese la hora (Hora/Minutos): ");
        String horaPermiso = opcion.nextLine();

        System.out.println("Ingrese cedula del residente: ");
        String cedulaResidente = opcion.nextLine();
        opcion.nextLine();

        System.out.println("Ingrese cedula del visitante: ");
        String visitantepermitido = opcion.nextLine();

        System.out.println("Ingrese la fecha de ingreso  (AAAA-MM-DD): ");
        String fechaIngreso1 = opcion.nextLine();
        LocalDate fechaAc = LocalDate.now();
        String fechaActual = String.valueOf(fechaAc);
        for (Visitante v : lista_Visitante) {
            if (v.getCedula().equals(visitantepermitido)) {
                if (fechaIngreso1.equals(fechaActual) && !v.getHistorial().equals(" ")) {
                    System.out.println("Fecha ingresada correcta");
                    System.out.println("No tiene sancion");
                } else {
                    System.out.println("No puede ingresar");
                }
            }
        }
        System.out.println("Ingrese la hora de ingreso (HH:MM):  ");
        String horaIngreso1 = opcion.nextLine();
        System.out.println("Ingrese duracion de la visita ");
        String duracion1 = opcion.nextLine();

    }

    public static void eliminarPermiso(ArrayList<Permiso> lista_Permisos, String cedula_ingresa) {
        Scanner opcion = new Scanner(System.in);
        System.out.println("Ingresa la cedula del visitante: ");
        String cedula_ingresada = opcion.nextLine();

        for (Permiso p : lista_Permisos) {

            if (p.getVisitantePermitido().equals(cedula_ingresada) && p.getResultado().equals(EstadoPermiso.ACTIVO)) {
                System.out.println((lista_Permisos.size() + 1) + ".  " + p);

            }
        }
        System.out.println("Ingrese el numero del permiso que desea eliminar: ");
        int numero = opcion.nextInt();

        for (Permiso pp : lista_Permisos) {
            if (pp.getResultado() == EstadoPermiso.ACTIVO) {
                pp.setResultado(EstadoPermiso.INACTIVO);
            }
        }

    }

    public static void consultarPermiso(ArrayList<Permiso> lista_Permisos, ArrayList<Residente> lista_Residentes, String mz_ingresa, String villa_ingresa) {
        int cuenta = 0;
        for (Permiso permisoAutorizado : lista_Permisos) {
            for (Residente r : lista_Residentes) {
                if (permisoAutorizado.getResidente().equals(r.getCedula())) {
                    if (r.getMz().equals(mz_ingresa) && r.getVilla().equals(villa_ingresa)) {
                        cuenta++;
                        System.out.println(permisoAutorizado);
                    }
                }
            }
        }
        if (cuenta == 0) {
            System.out.println("No se encontraron permisos con la mz y villa indicada.");
        }
    }

    public static String crearCodigo() {
        String[] letras = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String codigo = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int indice = random.nextInt(10);
            codigo += letras[indice];
        }
        return codigo;

    }

    @Override
    public int compareTo(Permiso otroPermiso) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime fechaHora1 = LocalDateTime.parse(this.fechaHora, formatter);
        LocalDateTime fechaHora2 = LocalDateTime.parse(otroPermiso.fechaHora, formatter);
        return fechaHora1.compareTo(fechaHora2);
    }
}
