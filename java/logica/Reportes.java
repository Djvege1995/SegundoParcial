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
public class Reportes {

    public void generarReporte(ArrayList<Residente> lista_residentes, ArrayList<Permiso> lista_Permisos) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cedula del residente : ");
        String cedula = sc.nextLine();
        for (Residente r : lista_residentes) {
            while (r.getCedula().equals(cedula)) {
                for (Permiso p : lista_Permisos) {

                }
            }

        }

    }
}
