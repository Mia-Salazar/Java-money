
public class Ingreso extends Dinero {
	//Constructor que inicializa los valores recibidos por par�metros
	public Ingreso(double ingreso, String description) {
		super.dinero = ingreso;
		super.description = description;
	}
	//Sobrescribimos la funci�n toString para que devuelva la informaci�n correctamente
	@Override
	public String toString() {
		return "Ingreso: " + description + ", cantidad:" + dinero + "�";
	}
}
