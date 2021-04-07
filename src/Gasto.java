
public class Gasto extends Dinero {
	public Gasto(double gasto, String description) {
		super.dinero = gasto;
		super.description = description;
	}
	@Override
	public String toString() {
		return "Gasto: " + description + ", cantidad: " + dinero + "€";
	}
}
