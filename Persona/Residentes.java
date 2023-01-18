package Persona;

import Permisos.EstadoPermiso;
import java.util.ArrayList;
import java.util.Scanner;
import Permisos.Permiso;



public class Residentes extends Personas{
    private Estado estado;
    public String mz;
    public String villa;

  

    public Residentes(String cedula, String nombre, String telefono, String email,String mz,String villa,Estado estado){
        super(cedula, nombre, telefono, email);
        this.estado = estado;
        this.mz=mz;
        this.villa=villa;
    }

    
    
    public String getMz(){
      return mz;
    }
    public void setMz(String mz){
      this.mz=mz;
    }
    public String getVilla(){
      return villa;
    }
    public void setVilla(String villa){
      this.villa=villa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public static void informacionResidentes(ArrayList<Residentes> lista_Residentes){
        Scanner opcion=new Scanner(System.in);
        System.out.println("Informacion residentes");
        System.out.println("1. Mostrar residentes");
        System.out.println("2. Agregar residentes");
        System.out.println("3. Editar informacion");
        System.out.println("4. Eliminar residente");
        System.out.println("ingrese una opcion");
        int op=opcion.nextInt();
        if(op==1){
            for(Residentes r:lista_Residentes){
                System.out.println(r.toString());
            }
        
        }
        if(op==2){
            System.out.println("------Ingrese la informacion------");
            String dato= opcion.nextLine();
            System.out.println("ingrese la cedula del residente: ");
            String nuevaCedula= opcion.nextLine();
        
            System.out.println("ingrese el nombre del residente: ");
            String nuevoNombre= opcion.nextLine();
            System.out.println("ingrese el telefono del residente: ");
            String nuevoTelefono= opcion.nextLine();
            System.out.println("ingrese el email del residente: ");
            String nuevoEmail= opcion.nextLine();
            System.out.println("ingrese el estado del residente: ");
            String nTipo= opcion.nextLine();
            System.out.println("ingrese la mz del residente: ");
            String mz = opcion.nextLine();
            System.out.println("ingrese villa del residente: ");
            String villa = opcion.nextLine();

            if(nTipo.equals("ACTIVO")){
                lista_Residentes.add(new Residentes(nuevaCedula,nuevoNombre,nuevoTelefono,nuevoEmail,mz,villa,Estado.ACTIVO));
            }
            if(nTipo.equals("INACTIVO")){
            lista_Residentes.add(new Residentes(nuevaCedula,nuevoNombre,nuevoTelefono,nuevoEmail,mz,villa,Estado.INACTIVO));
          }
         System.out.println("Residente fue agregado con exito.....!!!");         
                    
        }
        if(op==3){
          System.out.println("Editar informacion del residente");
          
          System.out.println("Lista de cedulas de los residentes");
         opcion.nextLine();
          
                     
          for(Residentes r:lista_Residentes){
            System.out.println(r.getCedula());
              } 
          System.out.println("Ingrese la cedula del residente a editar: ");
          String residenteEscogido=opcion.nextLine();

          
          boolean confirmacion=false;
          Residentes residente_modificado=null;

          for(Residentes r:lista_Residentes){
            
            if(r.getCedula().equals(residenteEscogido)){
              confirmacion=true;
              residente_modificado=r;
            }
                     
          }
          if(!confirmacion){
            System.out.println("No se encontro el residente.");
            return;
          }
          informacionResidentes(residente_modificado);
        } 
        if(op==4){
          System.out.println("Eliminar informacion del residente");
          System.out.println("Lista de cedulas de los residentes");
          opcion.nextLine();

          for(Residentes r:lista_Residentes){
            System.out.println(r.getCedula());
          }
          System.out.println("Ingrese la cedula del residente que quiere eliminar0956: ");
          String cedulaResidente=opcion.nextLine();
          
          boolean confir=false;
          Residentes residentes=null;
          for(Residentes r:lista_Residentes){
            if(r.getCedula().equals(cedulaResidente)){
              confir=true;
              residentes=r;
            }
          }
          if(!confir){
            System.out.println("No se encontro el residente.");
            return;
          }
          eliminarResidente(lista_Residentes,residentes);
           
        }
    }
    public static void informacionResidentes(Residentes r){
      Scanner opcion=new Scanner(System.in);
      System.out.println("ingrese el nuevo nombre del residente: ");
              String nuevoResidente= opcion.nextLine();
              r.setNombre(nuevoResidente);
              System.out.println("ingrese el nuevo telefono del residente: ");
              String nuevoTelefono= opcion.nextLine();
              r.setTelefono(nuevoTelefono);
              System.out.println("ingrese el nuevo email del cliente");
              String nuevoEmail= opcion.nextLine();
              r.setEmail(nuevoEmail);
    }
    
    
    
  public static void eliminarResidente(ArrayList<Residentes> lista_Residentes,Residentes residente){
      for(Residentes r:lista_Residentes){
        if(r.getCedula().equals(residente.getCedula())){
          r.setEstado(Estado.INACTIVO);
        }
      }
    }

  public String toString() {
        return super.toString() + "estado " + estado + " mz " + mz + ", villa" + villa ;
    }
  
}