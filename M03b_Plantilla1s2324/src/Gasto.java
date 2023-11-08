/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Gasto extends Dinero {
   	//inserta código aquí
	public Gasto(double gasto, String description) {
		// TODO Auto-generated constructor stub
		this.dinero = gasto;
		this.description = description; 
		
		
	}
	// configuracion de la impresion por pantalla la lista de gastos
	@Override
    public String toString() {
        return "Gasto{" +
                "dinero=" + getDinero() +
                ", descripcion='" + getDescription() + '\'' +
                '}';
    }
}
