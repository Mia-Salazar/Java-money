
public class Gasto extends Dinero {
	//Constructor que inicializa los valores recibidos por par�metros
	public Gasto(double gasto, String description) {
		super.dinero = gasto;
		super.description = description;
	}
	//Sobrescribimos la funci�n toString para que devuelva la informaci�n correctamente
	@Override
	public String toString() {
		return "Gasto: " + description + ", cantidad:" + dinero + "�";
	}
}
