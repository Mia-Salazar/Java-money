
public class Gasto extends Dinero {
	//Constructor que inicializa los valores recibidos por parámetros
	public Gasto(double gasto, String description) {
		super.dinero = gasto;
		super.description = description;
	}
	//Sobrescribimos la función toString para que devuelva la información correctamente
	@Override
	public String toString() {
		return "Gasto: " + description + ", cantidad:" + dinero + "€";
	}
}
