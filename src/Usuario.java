import java.util.regex.*;

public class Usuario {
	private String nombre;
	private int edad;
	private String DNI;
	
	public Usuario() {}
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
		this.DNI = DNI;
		Pattern pattern = Pattern.compile("[0-9]{8}(?:-)*[A-Z a-z]");
		Matcher matches = pattern.matcher(DNI);
		boolean correctDNI = matches.matches();
		return correctDNI;
	}
	public String toString() {
		return "A cambiar";
	}
}
