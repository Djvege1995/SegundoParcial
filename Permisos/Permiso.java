package Permisos;
import Persona.Visitante;
import Persona.Residentes;
import Persona.Personas;
import Persona.TipoEmpleado;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

/**
 *
 * @author apple
 */


public class Permiso {
 
    private String fecha;
    private String hora;
    public String residente;
    public String visitantePermitido;
    private String fechaIngreso;
    private String  horaIngreso;
    private int duracion;
    private int codigoVisitante;
    private EstadoPermiso resultado;
    
    public static int conCodigoVisitante = 0;

    public Permiso(String fecha, String hora, String residente, String visitantePermitido, String fechaIngreso, String horaIngreso, int duracion, int codigoVisitante,EstadoPermiso resultado) {
        this.fecha = fecha;
        this.hora = hora;
        this.residente = residente;
        this.visitantePermitido = visitantePermitido;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.duracion = duracion;
        this.codigoVisitante = conCodigoVisitante++ ;
        this.resultado=resultado;
    }

    public EstadoPermiso getResultado() {
        return resultado;
    }

    public void setResultado(EstadoPermiso resultado) {
        this.resultado = resultado;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getResidente() {
        return residente;
    }

    public void setResidente(String residente) {
        this.residente = residente;
    }

    public String getVisitantePermitido() {
        return visitantePermitido;
    }

    public void setVisitantePermitido(String visitantePermitido) {
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

    public void setHoraIngreso(String  horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCodigoVisitante() {
        return codigoVisitante;
    }

    public void setCodigoVisitante(int codigoVisitante) {
        this.codigoVisitante = codigoVisitante;
    }

    public static int getConCodigoVisitante() {
        return conCodigoVisitante;
    }

    public static void setConCodigoVisitante(int conCodigoVisitante) {
        Permiso.conCodigoVisitante = conCodigoVisitante;
    }

    /* Menu de permisos*/
    public static void modificarPermiso(ArrayList<Permiso>lista_Permisos, ArrayList<Visitante>lista_Visitante,ArrayList<Residentes>lista_Residentes){
        Scanner opcion =new Scanner(System.in);
        System.out.println("1. Agregar permiso");
        System.out.println("2. Eliminar permiso");
        System.out.println("3. Consultar permiso");
        System.out.println("4. Salir");
        System.out.println("Cual es su opcion: ");
        int op=opcion.nextInt();
        if( op==1){
          /*Agregar un permiso*/

            crearPermiso(lista_Permisos,lista_Visitante);
            
        }
        if(op==2){
          /*Eliminar un permiso*/
            System.out.println("Ingrese cedula del visitante: ");
            String cedula_ingresa=opcion.nextLine();
            opcion.nextLine();
            eliminarPermiso(lista_Permisos,cedula_ingresa);
          
           
          

        }
        if(op==3){
            /*Consultar un permiso*/
            System.out.println("Ingrese mz del residente: ");
          opcion.nextLine();
            String mz_ingresa=opcion.nextLine();
            System.out.println("Ingrese villa del residente: ");
            String villa_ingresa=opcion.nextLine();
          consultarPermiso(lista_Permisos,lista_Residentes,mz_ingresa,villa_ingresa);

            
            
        }
        else {
          return;

        }
      
    }
    
    
        
    public static void crearPermiso(ArrayList<Permiso> lista_Permisos,ArrayList<Visitante> lista_Visitante) {
            Scanner opcion =new Scanner(System.in);
            System.out.println("Ingrese la fecha (DD/MM/AAAA): ");
            String fechaPermiso=opcion.nextLine();
      
            System.out.println("Ingrese la hora (Hora/Minutos): ");
            String horaPermiso=opcion.nextLine();

      
            System.out.println("Ingrese cedula del residente: ");
            String cedulaResidente=opcion.nextLine();
             opcion.nextLine();
            
            System.out.println("Ingrese cedula del visitante: ");
            String visitantepermitido = opcion.nextLine();
      
            System.out.println("Ingrese la fecha de ingreso  (AAAA-MM-DD): ");
            String fechaIngreso1=opcion.nextLine();
            LocalDate fechaAc=LocalDate.now();
            String fechaActual= String.valueOf (fechaAc);
            for(Visitante v:lista_Visitante){
                if(v.getCedula().equals(visitantepermitido)){
                    if(fechaIngreso1.equals(fechaActual)&&  !v.getHistorial().equals(" ")){
                        System.out.println("Fecha ingresada correcta");
                        System.out.println("No tiene sancion");
                    }else{
                        System.out.println("No puede ingresar");
                    }
                }
            }
            System.out.println("Ingrese la hora de ingreso (HH:MM):  ");
            String horaIngreso1=opcion.nextLine();
            System.out.println("Ingrese duracion de la visita ");
            int duracion1 =opcion.nextInt();
            
            lista_Permisos.add(new Permiso(fechaPermiso,horaPermiso,cedulaResidente,visitantepermitido,fechaIngreso1,horaIngreso1,duracion1,getConCodigoVisitante(),EstadoPermiso.ACTIVO));
   }
 public static void eliminarPermiso(ArrayList<Permiso> lista_Permisos, String cedula_ingresa){
        Scanner opcion = new Scanner(System.in);
        ArrayList<Permiso> Permisos_Visita= new ArrayList<>();
        for(Permiso pa: lista_Permisos){
          if(pa.getVisitantePermitido().equals(cedula_ingresa)){
              System.out.println((Permisos_Visita.size() + 1) + ". " + pa.toString());
              Permisos_Visita.add(pa);
              
           }
        }
        System.out.println("Ingrese el numero del permiso que desea eliminar: ");
        int numero = opcion.nextInt();
        opcion.nextLine();
        while(numero > lista_Permisos.size() || numero<0){
            System.out.println("Numero ingresado es invalido");
            System.out.println("Ingrese el numero del permiso que desea eliminar: ");
            numero = opcion.nextInt(); 
            opcion.nextLine();
            
        }
        
        Permiso permiso1 = lista_Permisos.get(numero-1);
        if(permiso1.getResultado() == EstadoPermiso.ACTIVO){
            permiso1.setResultado(EstadoPermiso.INACTIVO);
       }
       
  
    }
    public static void consultarPermiso(ArrayList<Permiso> lista_Permisos,ArrayList<Residentes> lista_Residentes,String mz_ingresa, String villa_ingresa){
      int cuenta = 0;
      for(Permiso permisoAutorizado: lista_Permisos){
         for(Residentes r:lista_Residentes){
              if(permisoAutorizado.getResidente().equals(r.getCedula())){
                  if(r.getMz().equals(mz_ingresa)&& r.getVilla().equals(villa_ingresa)){
                      cuenta++;
                      System.out.println(permisoAutorizado);
                    }
               }
           }
      }
      if(cuenta == 0){
          System.out.println("No se encontraron permisos con la mz y villa indicada.");
      }
  }






  
  
}
    
