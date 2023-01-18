package Permisos;

import java.util.Scanner;
import Permisos.Permiso;
import Persona.Visitante;
import Persona.TipoEmpleado;
import Permisos.EstadoPermiso;
import Persona.Personas;
import java.util.ArrayList;
/**
 *
 * @author apple
 */
public class Revision {
   private Permiso permisoCreado;
    private String  Observacion;
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

   

    
    public static void verificarvisitante(ArrayList<Visitante> lista_Visitante,ArrayList<Permiso> lista_Permisos,ArrayList<Revision> lista_Actual){
        Scanner opcion =new Scanner(System.in);
        System.out.println("Ingrese el codigo del visitante");
        int codigo=opcion.nextInt();
    
        for(Permiso p:lista_Permisos){
            if(p.getCodigoVisitante()==(codigo)){
                System.out.println("Estado del permiso:"+p.getResultado());
               if(p.getResultado().equals(EstadoPermiso.ACTIVO)){
                   System.out.println("Ingrese observacion");
                   String Observacion1=opcion.nextLine();  
                   lista_Actual.add(new Revision(p,Observacion1,TipoEmpleado.GUARDIA,EstadoPermiso.USADO));
               }
   
            }else{
                System.out.println("Codigo incorrecto");
            }
            
        }

            
            
        }

    @Override
    public String toString() {
        return "permisoCreado/n " + permisoCreado + "/nObservacion  " + Observacion + " /ntrabajador " + trabajador + "/npermisoactual " + permisoactual ;
    }
}