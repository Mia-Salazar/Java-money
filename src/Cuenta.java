import java.util.ArrayList;

public class Cuenta {
	private double saldo;
	private Usuario usuario;
	private ArrayList<Gasto> gastos = new ArrayList<Gasto>();
	private ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();
	
	public Cuenta(Usuario usuario) {
		this.saldo = 0;
	}
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
		this.ingresos.add(new Ingreso(cantidad, description));
		this.saldo = this.saldo + cantidad;
		return this.saldo;
	}
	public double addGastos(String description, double cantidad) {
		try {
			if (this.saldo - cantidad < 0) {
				this.saldo = 0;
				throw new GastoException();
			} else {
				this.gastos.add(new Gasto(cantidad, description));
				this.saldo = this.saldo - cantidad;
			}
		} catch(GastoException error) {
			System.out.print(error.getMessage());
		}
		return this.saldo;
	}
	public ArrayList<Ingreso> getIngresos() {
		return this.ingresos;
	}
	
	public ArrayList<Gasto> getGastos() {
		return this.gastos;
	}
	public String toString() {
		return "El saldo actual de la cuenta es de: " + this.saldo + "€";
	}
}
