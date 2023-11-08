/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Usuario {
   	//inserta código aquí
	private String nombre;
    private int edad;
    private String DNI;


    public Usuario() {
  }

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {

    		this.edad = edad;

    }
    
    public String getDNI() {
    	return DNI;
    }


    public boolean setDNI(String DNI) {
    	// Verifica si el DNI tiene 8 numeros y una letra o 8 numero y - y una letra.
    	String validarDNI = "^(\\d{8}-?\\w)"
    			+ "$";
        if (DNI.matches(validarDNI)) {
            this.DNI = DNI;
            return true;
        } else {
            System.out.println("Por favor, introduce un DNI correcto.\n"
                    + "Formato correcto:\r\n"
                    + "Los primeros 8 caracteres solo podrán ser numéricos.\r\n"
                    + "El último carácter deberá ser una letra entre la a y la z (minúscula).\r\n"
                    + "El guion entre los números y la letra es opcional.\r\n"
                    + "EJEMPLO: \r\n"
                    + "DNI: 78844112m\r\n"
                    + "DNI: 78844112-m");
            return false;
        }
/*
*  	 Verifica si la longitud del DNI es 9 o 10 caracteres
*      if (DNI.length() == 9 || DNI.length() == 10) {
*          // Si la longitud es 9, verifica los primeros 7 caracteres como números
*          if (DNI.length() == 9) {
*              try {
*                  Long.parseLong(DNI.substring(0, 7));
*              } catch (NumberFormatException e) {
*                  // Si los primeros 7 caracteres no son números, el DNI es inválido
*              	System.out.println("Por favor, introduce un DNI correcto.\n"
*              			+ "Formato correcto:\r\n"
*              			+ "Los primeros 8 caracteres solo podrán ser numéricos.\r\n"
*              			+ "El ultimo caracteres deberá ser una letra MINÚSCULA entre\r\n"
*              			+ "la a y la z.\r\n"
*              			+ "El guion entre los números y la letra es opcional,\r\n"
*              			+ "admitiendo ambas posibilidades. EJEMPLO: \r\n"
*              			+ "DNI: 78844112m\r\n"
*              			+ "DNI: 78844112-m");
*              	return false;
*              }
*
*              // Verifica que el último carácter sea una letra mayúscula
*              char validarDNI = DNI.charAt(8);
*              if (Character.isUpperCase(validarDNI)) {
*                  // Si el último carácter no es una letra mayúscula, el DNI es inválido
*              	System.out.println("Por favor, introduce un DNI correcto.\n"
*              			+ "Formato correcto:\r\n"
*              			+ "Los primeros 8 caracteres solo podrán ser numéricos.\r\n"
*              			+ "El ultimo caracteres deberá ser una letra MINÚSCULA entre\r\n"
*              			+ "la a y la z.\r\n"
*              			+ "El guion entre los números y la letra es opcional,\r\n"
*              			+ "admitiendo ambas posibilidades. EJEMPLO: \r\n"
*              			+ "DNI: 78844112m\r\n"
*              			+ "DNI: 78844112-m");
*              	return false;
*              }
*          }
*          // Si la longitud es 10, verifica los primeros 7 caracteres como números
*          if (DNI.length() == 10) {
*              try {
*                  Long.parseLong(DNI.substring(0, 7));
*              } catch (NumberFormatException e) {
*                  // Si los primeros 7 caracteres no son números, el DNI es inválido
*              	System.out.println("Por favor, introduce un DNI correcto.\n"
*              			+ "Formato correcto:\r\n"
*              			+ "Los primeros 8 caracteres solo podrán ser numéricos.\r\n"
*              			+ "El ultimo caracteres deberá ser una letra MINÚSCULA entre\r\n"
*              			+ "la a y la z.\r\n"
*              			+ "El guion entre los números y la letra es opcional,\r\n"
*              			+ "admitiendo ambas posibilidades. EJEMPLO: \r\n"
*              			+ "DNI: 78844112m\r\n"
*              			+ "DNI: 78844112-m");
*              	return false;
*              }
*
*              // Verifica que el octavo carácter sea un guion y el último carácter sea una letra mayúscula
*              char validarDNI = DNI.charAt(8);
*              if (validarDNI == '-') {
*                  validarDNI = DNI.charAt(9);
*                  if (!Character.isUpperCase(validarDNI)) {
*                      // Si el último carácter no es una letra minuscula, el DNI es inválido
*                  	System.out.println("Por favor, introduce un DNI correcto.\n"
*                  			+ "Formato correcto:\r\n"
*                  			+ "Los primeros 8 caracteres solo podrán ser numéricos.\r\n"
*                  			+ "El ultimo caracteres deberá ser una letra MINÚSCULA entre\r\n"
*                  			+ "la a y la z.\r\n"
*                  			+ "El guion entre los números y la letra es opcional,\r\n"
*                  			+ "admitiendo ambas posibilidades. EJEMPLO: \r\n"
*                  			+ "DNI: 78844112m\r\n"
*                  			+ "DNI: 78844112-m");
*                      return false;
*                  }
*              } else {
*                  // Si el octavo carácter no es un guion, el DNI es inválido
*              	System.out.println("Por favor, introduce un DNI correcto.\n"
*              			+ "Formato correcto:\r\n"
*              			+ "Los primeros 8 caracteres solo podrán ser numéricos.\r\n"
*              			+ "El ultimo caracteres deberá ser una letra MINÚSCULA entre\r\n"
*              			+ "la a y la z.\r\n"
*              			+ "El guion entre los números y la letra es opcional,\r\n"
*              			+ "admitiendo ambas posibilidades. EJEMPLO: \r\n"
*              			+ "DNI: 78844112m\r\n"
*              			+ "DNI: 78844112-m");
*                  return false;
*              }
*          }
*          // Si todas las condiciones son verdaderas, el DNI es válido
*          // Asigna el DNI y devuelve true
*          this.DNI = DNI;
*          return true;
*      } else {
*          // Si la longitud del DNI no es 9 ni 10, el DNI es inválido
*      	System.out.println("Por favor, introduce un DNI correcto.\n"
*      			+ "Formato correcto:\r\n"
*      			+ "Los primeros 8 caracteres solo podrán ser numéricos.\r\n"
*      			+ "El ultimo caracteres deberá ser una letra MINÚSCULA entre\r\n"
*      			+ "la a y la z.\r\n"
*      			+ "El guion entre los números y la letra es opcional,\r\n"
*      			+ "admitiendo ambas posibilidades. EJEMPLO: \r\n"
*      			+ "DNI: 78844112m\r\n"
*      			+ "DNI: 78844112-m");
*          
*          return false;
*/
        }
     
        
    

    @Override
    public String toString() {
        return "Nombre : '" + nombre + '\'' +
                "  Edad : " + edad +
                "  DNI : " + DNI;
    }
}
