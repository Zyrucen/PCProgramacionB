/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Ingreso extends Dinero{
   	//inserta código aquí
	public Ingreso(String description, double ingreso) {
		// TODO Auto-generated constructor stub
		this.dinero = ingreso;
		this.description = description; 
		
	}
	// configuracion de la impresion por pantalla la lista de ingresos
	@Override
    public String toString() {
        return "Ingreso{" +
                "dinero=" + getDinero() +
                ", descripcion='" + getDescription() + '\'' +
                '}';
    }
}
