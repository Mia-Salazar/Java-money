import java.util.ArrayList;

public class Cuenta {
	//Declaramos las variables necesarias
	private double saldo;
	private Usuario usuario;
	private ArrayList<Gasto> gastos = new ArrayList<Gasto>();
	private ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();
	
	//Constructor
	public Cuenta(Usuario usuario) {
		this.saldo = 0;
	}
	
	//Declaramos los setters y los getters
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
	public double addIngresos(String description, double cantidad) {
		//Aañadimos un ingreso y sumamos a saldo la cantidad que hemos recibido por parámetros
		this.ingresos.add(new Ingreso(cantidad, description));
		this.saldo = this.saldo + cantidad;
		return this.saldo;
	}
	public double addGastos(String description, double cantidad) {
		//Creamos unos bloques try...catch para que, en caso de que le restemos menos de lo que tiene en la cuenta, salte la excepción
		try {
			//En caso de que el saldo resultante sea menos que 0 lanzamos la excepción
			if (this.saldo - cantidad < 0) {
				throw new GastoException();
			} else {
				//Aañadimos un gasto nuevo y lo restamos si el saldo resultante es mayor que 0
				this.gastos.add(new Gasto(cantidad, description));
				this.saldo = this.saldo - cantidad;
			}
		} catch(GastoException error) {
			//Cuando se dispare la excepción, lanzamos un mensaje indicándole que no tiene saldo
			System.out.print(error.getMessage() + "\n");
		}
		return this.saldo;
	}
	//Retornamos la lista de Ingresos
	public ArrayList<Ingreso> getIngresos() {
		return this.ingresos;
	}
	//Retornamos la lista de Gastos
	public ArrayList<Gasto> getGastos() {
		return this.gastos;
	}
	//Sobrescribimos la función toString para que devuelva la información correctamente
	public String toString() {
		return "El usuario es:" + usuario.getNombre() + "\n." +
				"Su edad es:" + usuario.getEdad() + "\n." +
				"Su DNI es:" + usuario.getDNI() + "\n." +
				"El saldo actual de la cuenta es de: " + this.saldo + "€.";
	}
}
