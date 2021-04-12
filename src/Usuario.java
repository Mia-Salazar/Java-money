import java.util.regex.*;

public class Usuario {
	//Declaramos las variables necesarias
	private String nombre;
	private int edad;
	private String DNI;
	
	//Constructor
	public Usuario() {}
	
	//Declaramos los setters y getters
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
		//Comprobamos que el DNI es el correcto y retornamos un booleano
		Pattern pattern = Pattern.compile("[0-9]{8}(?:-)*[A-Z a-z]");
		Matcher matches = pattern.matcher(DNI);
		boolean correctDNI = matches.matches();
		if (correctDNI) {
			this.DNI = DNI;
		}
		return correctDNI;
	}
	//Sobrescribimos la función toString para que devuelva la información correctamente
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n" + "Edad: " + this.edad + "DNI: " + this.DNI;
    }
}
