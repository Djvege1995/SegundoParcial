/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Michael
 */
public class Urbanizacion {

    private SimpleStringProperty nombre, etapa, direccion, constructora, emailAdministrador;
    private Colaborador personaResponsable;

    public Urbanizacion(String nombre, String etapa, String emailAdministrador, String direccion, String constructora, Colaborador personaResponsable) {
        this.nombre = new SimpleStringProperty(nombre);
        this.etapa = new SimpleStringProperty(etapa);
        this.emailAdministrador = new SimpleStringProperty(emailAdministrador);
        this.direccion = new SimpleStringProperty(direccion);
        this.constructora = new SimpleStringProperty(constructora);
        this.personaResponsable = personaResponsable;
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

    public String getEtapa() {
        return etapa.get();
    }

    public SimpleStringProperty etapaProperty() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa.set(etapa);
    }

    public String getEmailAdministrador() {
        return emailAdministrador.get();
    }

    public SimpleStringProperty emailAdministradorProperty() {
        return emailAdministrador;
    }

    public void setEmailAdministrador(String emailAdministrador) {
        this.emailAdministrador.set(emailAdministrador);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public SimpleStringProperty direccionProperty() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public String getConstructora() {
        return constructora.get();
    }

    public SimpleStringProperty constructoraProperty() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora.set(constructora);
    }

    public Colaborador getPersonaResponsable() {
        return personaResponsable;
    }

    public Colaborador personaResponsableProperty() {
        return personaResponsable;
    }

    public void setPersonaResponsable(Colaborador personaResponsable) {
        this.personaResponsable = personaResponsable;
    }

    public static void informacionUrbanicacion(ArrayList<Urbanizacion> lista_urbanizacion, ArrayList<Colaborador> lista_colaboradores) {
        Scanner opcion = new Scanner(System.in);
        System.out.println("Menu Urbanizacion");
        System.out.println("1. Agregar informacion");
        System.out.println("2. Editar informacion");
        System.out.println("ingrese una opcion");
        int op = opcion.nextInt();
        if (op == 1) {
            opcion.nextLine();
            System.out.println("Ingrese el nombre Urbanizacion: ");
            String nombreU = opcion.nextLine();
            System.out.println("Ingrese la etapa: ");
            String etapa = opcion.nextLine();
            System.out.println("Ingrese el email de administracion: ");
            String email = opcion.nextLine();
            System.out.println("Ingrese la constructora: ");
            String constructora = opcion.nextLine();
            System.out.println("Ingrese la direccion: ");
            String direccion = opcion.nextLine();

            System.out.println("Administradores Registrados");

            for (Colaborador c : lista_colaboradores) {
                if (c.getTipoEmpleado().equals(TipoEmpleado.ADMINISTRADOR)) {
                    System.out.println(c.getCedula());
                }
            }
            System.out.println("Elija el administrador:");
            String elegido = opcion.nextLine();
            boolean confirmacion = false;
            Colaborador admi = null;
            for (Colaborador c1 : lista_colaboradores) {
                if (c1.getCedula().equals(elegido)) {
                    confirmacion = true;
                    admi = c1;
                }
            }
            if (!confirmacion) {
                System.out.println("No se encontro administrador");
                return;
            }
            lista_urbanizacion.add(new Urbanizacion(nombreU, etapa, email, constructora, direccion, admi));

        }
        if (op == 2) {
            System.out.println("Administradores Registrados");
            for (Colaborador c : lista_colaboradores) {
                if (c.getTipoEmpleado().equals(TipoEmpleado.ADMINISTRADOR)) {
                    System.out.println(c.getCedula());
                }
            }
            System.out.println("Ingrese su nuevo administrador");
            String elegido = opcion.nextLine();
            boolean confirmacion = false;
            Urbanizacion urb = null;
            for (Urbanizacion u : lista_urbanizacion) {
                if (u.getPersonaResponsable().getCedula().equals(elegido)) {
                    confirmacion = true;
                    urb = u;
                }
            }
            if (!confirmacion) {
                System.out.println("No se encontro administrador");
                return;
            }
            modificador(urb);
        }
    }

    public static void modificador(Urbanizacion u) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre: ");
        String nuevoNombre = sc.nextLine();
        u.setNombre(nuevoNombre);
        System.out.println("Ingrese la nueva etapa: ");
        String nuevaEtapa = sc.nextLine();
        u.setEtapa(nuevaEtapa);
        System.out.println("Ingrese la nueva email Administrador: ");
        String nuevoEmail = sc.nextLine();
        u.setEmailAdministrador(nuevoEmail);
        System.out.println("Ingrese nueva direccion: ");
        String nuevaDireccion = sc.nextLine();
        u.setDireccion(nuevaDireccion);
        System.out.println("Ingrese nueva constructora: ");
        String nuevaConstructora = sc.nextLine();
        u.setConstructora(nuevaConstructora);
        sc.close();
    }
    
}
