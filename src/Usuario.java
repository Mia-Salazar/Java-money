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
		 Pattern p = Pattern.compile("[0-9]{8}(?:-)*[A-Z a-z]");
		 Matcher m = p.matcher(DNI);
		 boolean b = m.matches();
		 return b;
	}
	public String toString() {
		return "A cambiar";
	}
}
