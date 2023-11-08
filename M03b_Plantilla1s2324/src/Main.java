import java.util.Scanner;
/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */

public class Main {

    public static void main(String[] args) throws GastoException  {
        // Inserta código aquí
    	
    	// Lee los datos del usuario y crea una cuenta con esos datos
        Usuario usuario = LeerUsuario();
        Cuenta cuenta = new Cuenta(usuario);
        mostrarMenu(cuenta);
    }
    
    /**** Mostrar las distintas opciones validas del Menu de Opciones  ****/

    public static void mostrarMenu(Cuenta cuenta) throws GastoException {
        Scanner opt = new Scanner(System.in);
        int opcion;
        
        //Se crea un Do para mostrar en bucle el menú hasta que la opcion del usuario sea un "0"
        
        try {
        	
        
	        do {
	        	
	        	//Opciones del menu principal
	        	
	            System.out.println("Realiza una nueva acción");
	            System.out.println("1. Introduce un nuevo gasto");
	            System.out.println("2. Introduce un nuevo ingreso");
	            System.out.println("3. Mostrar gastos");
	            System.out.println("4. Mostrar ingresos");
	            System.out.println("5. Mostrar saldo");
	            System.out.println("0. Salir: ");
	            System.out.print("\033[9B> ");
	         
	            
	            // Lee la opción del usuario
	            opcion = opt.nextInt();
	
	            switch (opcion) {
	                case 1:
	                	// Agrega un nuevo gasto a la cuenta
	                    addGastos(cuenta);
	                    break;
	                    
	                case 2:
	                	// Agrega un nuevo ingreso a la cuenta
	                    addIngresos(cuenta);
	                    break;
	                    
	                case 3:
	                	// Muestra los gastos de la cuenta
	                    imprimirGastos(cuenta);
	                    break;
	                    
	                case 4:
	                	// Muestra los ingresos de la cuenta
	                    imprimirIngresos(cuenta);
	                    break;
	                    
	                case 5:
	                	// Muestra el saldo de la cuenta
	                	System.out.println(cuenta.toString());
	                    break;
	                    
	                case 0:
	                	// Sale del programa
	                    System.out.println("Fin del programa.\r\n"
	                    		+ "Gracias por utilizar la aplicación de M03B en el curso 1s2324.");
	                    break;
	                    
	                default:
	                	// Opción inválida
	                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
	                    break;
	            }
	        } while (opcion != 0);
	        
	        // Cierra el scanner
	        opt.close();
	        
        }catch (Exception e) {
        	System.out.println("\"Opción inválida. Por favor, seleccione una opción válida.\"");
        	opt.next();
        } 
        opt.close();
    }

    
    /**** Función que lee por teclado los datos del usuario y los devuelve como un objeto de tipo Usuario. ****/

    private static Usuario LeerUsuario() {
        Scanner user = new Scanner(System.in);
        Usuario usuario = new Usuario();

        // Lee el nombre del usuario
        System.out.println("Introduce un nombre de usuario:");
        System.out.print("\033[9B> ");
        usuario.setNombre(user.nextLine());

        // Lee la edad del usuario y valida la entrada
        short validar;
        do {
        	
	        try{ 
	        	System.out.println("Introduce su edad:");
	        	System.out.print("\033[9B> ");
	        	validar = 1;
	        	usuario.setEdad(user.nextInt());
	            // Consumir el carácter pendiente después de nextInt()
	            user.nextLine();
		        
	        } catch (Exception e) {
	        	// Muestra un mensaje de error y vuelve a solicitar la edad
	        	System.out.println("Por favor, la edad tiene que ser un numero, empieza de nuevo. \n");
	        	System.out.print("\033[9B> ");
	        	validar = 0;
	        	user.nextLine();
	        }

        } while (validar != 1);
        
        

        // Lee el DNI del usuario
        do {
            System.out.println("Introduce un DNI:");
        } while (!usuario.setDNI(user.nextLine()));

        // Feedback sobre la creación del usuario correctamente.
        System.out.println("Usuario creado correctamente.\n" + usuario.toString());

        return usuario;
    }

    /**** Funcion que lee por teclado un ingreso, lo agrega a la lista de ingresos y muestra mensaje ****/
    
    private static void addIngresos(Cuenta cuenta) {
        Scanner ingscan = new Scanner(System.in);
        System.out.println("Introduce la descripción del ingreso:");
        String descripcion = ingscan.nextLine();
        System.out.println("Introduce la cantidad del ingreso:");
        double cantidad = ingscan.nextDouble();
        // Agrega el ingreso a la cuenta
        cuenta.addIngresos(descripcion, cantidad);
        System.out.println("Ingreso añadido correctamente. Nuevo " + cuenta.toString());
        // Consumir el carácter pendiente después de nextDouble()
        ingscan.nextLine();
    }

    /**** Muestra por pantalla el listado de ingresos ****/

    private static void imprimirIngresos(Cuenta cuenta) {
    	
    	System.out.println("Lista de ingresos:  \n");
    	for (Ingreso ingreso : cuenta.getIngresos()) {
            System.out.println("Descripción: " + ingreso.toString() );
            System.out.println("Cantidad: " + String.format("%.2f", ingreso.dinero ) +"€" );
            System.out.println("--------------");
    	}
    }

    /**** Funcion que lee por teclado un Gasto y lo agrega a la lista de gastos  y muestra mensaje 
     * @throws GastoException ****/
    
    private static void addGastos(Cuenta cuenta) throws GastoException {
    	
    		
            Scanner gastscan = new Scanner(System.in);
            System.out.println("Introduce la descripción del gasto:");
            String descripcion = gastscan.nextLine();
            System.out.println("Introduce la cantidad del gasto:");
            double cantidad = gastscan.nextDouble();
            // Agrega el gasto a la cuenta o muestra un mensaje de error si no hay suficiente saldo
            try {
            	cuenta.addGastos(descripcion, cantidad);
            } catch (GastoException e) {
            	System.out.println("Error al agregar el gasto, no tienes suficiente saldo en tu cuenta. Saldo: " + String.format("%.2f", cuenta.getSaldo()) + "€");
            }
            
            // Consumir el carácter pendiente después de nextDouble()
            gastscan.nextLine();
    		

    }

    /**** Muestra por pantalla el listado de gastos ****/
    
    private static void imprimirGastos(Cuenta cuenta) {
    	
    	System.out.println("Lista de Gastos:  \n");
    	for (Gasto gasto : cuenta.getGastos()) {
            System.out.println("Descripción: " + gasto.description );
            System.out.println("Cantidad: " + String.format("%.2f", gasto.dinero) + "€");
            System.out.println("--------------");
    }
    }
}
