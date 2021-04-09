
public class Ingreso extends Dinero {
	public Ingreso(double ingreso, String description) {
		super.dinero = ingreso;
		super.description = description;
	}
	@Override
	public String toString() {
		return "Ingreso: " + description + ", cantidad:" + dinero + "€";
	}
}
