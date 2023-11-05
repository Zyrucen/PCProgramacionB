/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class GastoException extends Exception{
   	//inserta código aquí
	public GastoException() {
        super("Error en el gasto: el monto del gasto debe ser mayor que cero.");
    }
}
