package Persona;
import Persona.Personas;
import java.util.ArrayList;
/**
 *
 * @author alber
 */
public class Colaboradores extends Personas {
    private String fechainicio;
    private String fechafin;
    private TipoEmpleado tipoEmpleado;
    private Estado estado;
    private String puestoTrabajo;
  
    public Colaboradores(String fechainicio,String fechafin, TipoEmpleado tipoEmpleado, Estado estado,String puestoTrabajo, String cedula, String nombre, String telefono, String email){
      super(cedula, nombre, telefono, email);

        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.tipoEmpleado = tipoEmpleado;
        this.estado = estado;
        this.puestoTrabajo=puestoTrabajo;
    }
    
    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public String getpuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setpuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }
    
    public static void informacionEmpleado(ArrayList<Colaboradores> lista_Colaboradores){
      System.out.println("Informacion de los empleados");
      for(Colaboradores c:lista_Colaboradores){
        System.out.println(c);
      }
      
    }
    @Override
    public String toString() {
       System.out.println("----------Colaborador--------------");
        return "fecha inicio  " + fechainicio +"\nfecha fin " + fechafin + "\ntipoEmpleado " + tipoEmpleado + "\nestado " + estado + "\npuestoTrabajo " + puestoTrabajo;

      
    
    }
      
}