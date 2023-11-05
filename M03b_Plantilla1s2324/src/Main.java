import java.util.Scanner;
/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */

public class Main {

    public static void main(String[] args) {
        // Inserta código aquí
        Usuario usuario = LeerUsuario();
        Cuenta cuenta = new Cuenta(usuario);
        mostrarMenu(cuenta);
    }
    /**** Mostrar las distintas opciones validas del Menu de Opciones ****/

    public static void mostrarMenu(Cuenta cuenta) {
        Scanner opt = new Scanner(System.in);
        int opcion;

        do {
        	
            System.out.println("Realiza una nueva acción");
            System.out.println("1. Introduce un nuevo gasto");
            System.out.println("2. Introduce un nuevo ingreso");
            System.out.println("3. Mostrar gastos");
            System.out.println("4. Mostrar ingresos");
            System.out.println("5. Mostrar saldo");
            System.out.println("0. Salir: ");
            opcion = opt.nextInt();

            switch (opcion) {
                case 1:
                    addGastos(cuenta);
                    System.out.println(cuenta.toString());
                    break;
                case 2:
                    addIngresos(cuenta);
                    System.out.println(cuenta.toString());
                    break;
                case 3:
                    imprimirGastos(cuenta);
                    break;
                case 4:
                    imprimirIngresos(cuenta);
                    break;
                case 5:
                	System.out.println(cuenta.toString());
                    break;
                case 0:
                    System.out.println("Fin del programa.\r\n"
                    		+ "Gracias por utilizar la aplicación de M03B en el curso 1s2324.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);
        
        opt.close();
    }

    /**** Función que lee por teclado los datos del usuario y los devuelve como un objeto de tipo Usuario. ****/

    private static Usuario LeerUsuario() {
        Scanner user = new Scanner(System.in);
        Usuario usuario = new Usuario();

        System.out.println("Introduce un nombre de usuario:");
        usuario.setNombre(user.nextLine());

        System.out.println("Introduce su edad:");
        usuario.setEdad(user.nextInt());
        // Consumir el carácter pendiente después de nextInt()
        user.nextLine();

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
        cuenta.addIngresos(descripcion, cantidad);
        System.out.println("Ingreso añadido correctamente. Nuevo " + cuenta.toString());
        // Consumir el carácter pendiente después de nextDouble()
        ingscan.nextLine();
    }

    /**** Muestra por pantalla el listado de ingresos ****/

    private static void imprimirIngresos(Cuenta cuenta) {
    	
    
    	System.out.println("Lista de Gastos:  \n");
    	for (Ingreso ingreso : cuenta.getIngresos()) {
            System.out.println("Descripción: " + ingreso.description );
            System.out.println("Cantidad: " + ingreso.dinero );
            System.out.println("--------------");
    	}
    }

    /**** Funcion que lee por teclado un Gasto y lo agrega a la lista de gastos  y muestra mensaje ****/
    
    private static void addGastos(Cuenta cuenta) {
    	
    		
            Scanner gastscan = new Scanner(System.in);
            System.out.println("Introduce la descripción del gasto:");
            String descripcion = gastscan.nextLine();
            System.out.println("Introduce la cantidad del gasto:");
            double cantidad = gastscan.nextDouble();
            cuenta.addGastos(descripcion, cantidad);
            
            // Consumir el carácter pendiente después de nextDouble()
            gastscan.nextLine();
    		

    }

    /**** Muestra por pantalla el listado de gastos ****/
    
    private static void imprimirGastos(Cuenta cuenta) {
    	
    	System.out.println("Lista de Gastos:  \n");
    	for (Gasto gasto : cuenta.getGastos()) {
            System.out.println("Descripción: " + gasto.description );
            System.out.println("Cantidad: " + gasto.dinero );
            System.out.println("--------------");
    }
    }
}
