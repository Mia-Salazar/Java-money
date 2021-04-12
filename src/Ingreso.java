
public class Ingreso extends Dinero {
	//Constructor que inicializa los valores recibidos por parámetros
	public Ingreso(double ingreso, String description) {
		super.dinero = ingreso;
		super.description = description;
	}
	//Sobrescribimos la función toString para que devuelva la información correctamente
	@Override
	public String toString() {
		return "Ingreso: " + description + ", cantidad:" + dinero + "€";
	}
}
