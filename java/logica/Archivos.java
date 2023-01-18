/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Clase para leer y escribir archivos
 *
 * @author pro
 */
public class Archivos {

    /**
     * Metodo para leer archivos
     *
     * @param Archivo string que es el nombre del archivo con su extensión
     * @return devuelve una lista de lineas del archivo
     */
    public static ArrayList<String> leerArchivo(String Archivo) {
        ArrayList<String> lineas = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(Archivo, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo");
        } catch (IOException ex) {
            System.out.println("Error");
        }
        return lineas;
    }

    /**
     * Metodo que escribe una linea en el archivo especificado
     *
     * @param archivo string que es el nombre del archivo con su extensión
     * @param mensaje string que es lo que se va a escribir en el archivo
     */
    public static void escribirArchivo(String archivo, String mensaje) {
        String lineSeparator = System.lineSeparator();

        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(new File(archivo), true))) {
            bw.write(lineSeparator+mensaje);
        } catch (IOException ex) {

        }

    }

    public static void actualizarArchivo(String archivo, String mensaje) {


        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(new File(archivo), false))) {
            bw.write( mensaje);
        } catch (IOException ex) {

        }

    }

    /**
     * Metodo para generar un arreglo de strings que contiene cada linea del
     * archivo ya separado cada elemento por la coma
     *
     * @param archivo string que es el nombre del archivo con su extensión
     * @return un arreglo de strings que contiene cada linea hecha split
     */
    public static ArrayList<String[]> generarArreglo(String archivo) {
        ArrayList<String> variableGenerado = leerArchivo(archivo);
        ArrayList<String[]> arregloFinal = new ArrayList();
        for (int a = 1; a < variableGenerado.size(); a++) {
            String[] linea = variableGenerado.get(a).split(",");
            arregloFinal.add(linea);
        }
        return arregloFinal;
    }

}
