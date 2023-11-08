import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

    // Constructor que recibe un objeto Usuario para inicializar la cuenta
    public Cuenta(Usuario usuario) {
        this.saldo = 0.0;
        this.usuario = usuario;
        this.gastos = new ArrayList<>();
        this.ingresos = new ArrayList<>();
    }

    // Método para obtener el saldo de la cuenta
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    // Método para agregar un ingreso a la cuenta
    public double addIngresos(String description, double cantidad) {
        Ingreso ingreso = new Ingreso(cantidad, description);
        ingresos.add(ingreso);
        setSaldo(getSaldo() + cantidad);  // Actualizar el saldo usando el método setSaldo
        return saldo;
    }

    // Método para agregar un gasto a la cuenta
    public double addGastos(String description, double cantidad) throws GastoException {
        Gasto gasto = new Gasto(cantidad, description);
        // Lanza una excepción si el gasto es mayor que el saldo disponible
        if (cantidad > getSaldo()) {
            throw new GastoException();
        } else {
            // Agrega el gasto a la lista y actualiza el saldo
            gastos.add(gasto);
            setSaldo(getSaldo() - cantidad);  // Actualizar el saldo usando el método setSaldo
            System.out.println("Gasto añadido correctamente. Nuevo saldo: " + String.format("%.2f", getSaldo()) + "€");
        }
        return saldo;
    }

    // Método para obtener la lista de ingresos de la cuenta
    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    // Método para obtener la lista de gastos de la cuenta
    public List<Gasto> getGastos() {
        return gastos;
    }

    // Método toString para representar la cuenta como una cadena de texto
    @Override
    public String toString() {
        return "SALDO: " + String.format("%.2f", saldo) + "€";
    }
}