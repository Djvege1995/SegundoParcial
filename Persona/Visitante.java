package Persona;
import java.util.ArrayList;
import java.util.Scanner;
import Persona.Residentes;
/**
 *
 * @author apple
 */

    
public class Visitante extends Personas{
  String  empresa, historial;
  public Visitante (String cedula, String nombre, String telefono, String email,String empresa,String historial){
    super(cedula, nombre, telefono, email);
    this.empresa=empresa;
    this.historial=historial;
    
  }
  public String getHistorial(){
    return historial;
  
  }
  public String getEmpresa(){
    return empresa;
  }
  public void setHistorial(String historial){
    this.historial=historial;
  }
  public void setEmpresa(String empresa){
    this.empresa=empresa;
  }
  //creacion de menu para visitantes.
  public static void informacionVisitantes(ArrayList<Visitante> lista_Visitante){
     Scanner opcion=new Scanner(System.in);
     System.out.println("Informacion visitante");
     System.out.println("1.Agregar visitante");
     System.out.println("2.Editar visitante");
     int op=opcion.nextInt();

    
     if(op==1){
      System.out.println("----Ingrese la informacion---- ");
      opcion.nextLine();
      System.out.println("ingrese la cedula del visitante: ");
      String nuevaCedula = opcion.nextLine();
      System.out.println("ingrese el nombre del visitante: ");
      String nuevoNombre= opcion.nextLine();
      System.out.println("ingrese el telefono del visitante: ");
      String nuevoTelefono= opcion.nextLine();
      System.out.println("ingrese el email del visitante: ");
      String nuevoEmail= opcion.nextLine();
      System.out.println("¿Es un repartidor SI-NO?");
      String repartidor=opcion.nextLine();
      System.out.println("ingrese el historial del visitante: ");
      String history= opcion.nextLine();
      
      
       if(repartidor.equals("Si")){
         System.out.println("Ingrese el nombre de la empresa donde trabaja");
         String nomEmpresa=opcion.nextLine();
         lista_Visitante.add(new Visitante(nuevaCedula,nuevoNombre,nuevoTelefono,nuevoEmail,nomEmpresa,history));
       }
       else{
         System.out.println(" ");
         String vac=opcion.nextLine();
         lista_Visitante.add(new Visitante(nuevaCedula,nuevoNombre,nuevoTelefono,nuevoEmail,vac, history));

       }
         System.out.println(" ");
       }
  
     
     if(op==2){
       System.out.println("----Editar informacion----");
       opcion.nextLine();
       
       for(Visitante v:lista_Visitante){
         System.out.println(v.getCedula());
       }
       System.out.println("Ingrese la cedula del visitante: ");
       String visitanteEscogido=opcion.nextLine();
       boolean confirmacion=false;
       Visitante visitante_modificado=null;
       for(Visitante v:lista_Visitante){
         if(v.getCedula().equals(visitanteEscogido)){
           confirmacion=true;
           visitante_modificado=v;
         }
                     
       }
       if(!confirmacion){
         System.out.println("No se encontro el visitante.");
         return;
       }
       informacionVisitantes(visitante_modificado);
     }
  }

  // Modulacion para modificar visitante  y ahorrar lineas de codigo     
  public static void informacionVisitantes(Visitante v){
    Scanner opcion=new Scanner(System.in);
       System.out.println("ingrese el nuevo nombre del visitante: ");
       String nuevoVisitante= opcion.nextLine();
       v.setNombre(nuevoVisitante);
       System.out.println("ingrese el nuevo telefono del visitante: ");
       String nuevoTelefono= opcion.nextLine();
       v.setTelefono(nuevoTelefono);
       System.out.println("ingrese el nuevo email del cliente");
       String nuevoEmail= opcion.nextLine();
       v.setEmail(nuevoEmail);
  }
  
}
