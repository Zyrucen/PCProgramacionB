
import java.util.ArrayList;
import java.util.List;
/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Cuenta {

   	//inserta código aquí
	
	
	private Double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

    public Cuenta(Usuario usuario) {
        this.saldo = 0.0;
        this.usuario = usuario;
        this.gastos = new ArrayList<>();
        this.ingresos = new ArrayList<>();
    }

    public Cuenta() {
		// TODO Auto-generated constructor stub
    	this.saldo = 0.0;
        this.usuario = usuario;
        this.gastos = new ArrayList<>();
        this.ingresos = new ArrayList<>();
	}

    public Double getSaldo() {
        return saldo;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double addIngresos(String description, double cantidad) {
        Ingreso ingreso = new Ingreso(description, cantidad);
        ingresos.add(ingreso);
        saldo += cantidad;
        return saldo;
    }

    public double addGastos(String description, double cantidad) {
        
    	
    	Gasto gasto = new Gasto(description, cantidad);
    	if (cantidad > saldo) {
            
            System.out.println("No tienes suficiente dinero para ese gasto. Saldo: " + String.format("%.2f", saldo) + "€");
           
    	}else {
    		gastos.add(gasto);
            saldo -= cantidad;
            System.out.println("Gasto añadido correctamente. Nuevo saldo: " + String.format("%.2f", saldo) + "€");
    	}
    	return saldo;
   }
    
    public List<Ingreso> getIngresos() {
        
    	return ingresos;
    }

    public List<Gasto> getGastos() {
    	
    	
    	return gastos;
    }

    @Override
    public String toString() {
        return "SALDO :" + String.format("%.2f", saldo) + "€";
    }
}
