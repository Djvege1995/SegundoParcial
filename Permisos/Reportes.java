package Permisos;
import java.util.Scanner;
import java.util.ArrayList;
import Persona.Residentes;
import Permisos.Permiso;



public class Reportes {
 public void generarReporte(ArrayList<Residentes> lista_residentes,ArrayList<Permiso> lista_Permisos){
     
            Scanner sc =new Scanner(System.in);
            System.out.println("Ingrese la cedula del residente : ");
            String cedula=sc.nextLine();
            for(Residentes r:lista_residentes){
            while(r.getCedula().equals(cedula)){
			for(Permiso p:lista_Permisos){
				
			}
		}

	}

}
}