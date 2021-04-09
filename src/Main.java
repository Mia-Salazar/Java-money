import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String nombre;
		int edad;
		String DNI;
		Usuario usuario;
		Cuenta cuenta;
		Scanner sc = new Scanner(System.in);
		
		usuario = new Usuario();
		System.out.println("Introduce el nombre del usuario");
		nombre = sc.nextLine();
	    while (nombre == "") {
			System.out.println("Nombre introducido incorrecto");
	        System.out.println("Introduce el Nombre del usuario válido");
	        nombre = sc.nextLine();
	    }
		usuario.setNombre(nombre);
		
		System.out.println("Introduce la edad del usuario");
		do {
		    try {
				edad = sc.nextInt();
				sc.nextLine();
		    	usuario.setEdad(edad);
		    } catch (NumberFormatException error) {
				System.out.println("Edad introducida incorrecta");
		        System.out.println("Introduce la edad del usuario válida");
		    }
		} while (usuario.getEdad() == 0);
		
		
		System.out.println("Introduce el DNI del usuario");
		DNI = sc.nextLine();
	    while (!usuario.setDNI(DNI)) {
			System.out.println("DNI introducido incorrecto");
	        System.out.println("Introduce el DNI del usuario válido");
	 		DNI = sc.nextLine();
	    }
	    cuenta = new Cuenta(usuario);
	    System.out.println("Usuario creado correctamente");
	    
	    menu(cuenta);
	    sc.close();
		
	}
	
	public static void menu(Cuenta cuenta) {
		int number;
		double dinero;
		Gasto gasto;
		Ingreso ingreso;
		String description;
		Scanner sc = new Scanner(System.in);
		ArrayList<Gasto> gastos;
		ArrayList<Ingreso> ingresos;
		
		do {
			System.out.println("Realiza una nueva acción\n"
					+ "1 Introduce un nuevo gasto\n"
					+ "2 Introduce un nuevo ingreso\n"
					+ "3 Mostrar gastos\n"
					+ "4 Mostrar ingresos\n"
					+ "5 Mostrar salgo\n"
					+ "0 Salir");
			number = sc.nextInt();
			sc.nextLine();
			switch(number) {
			  case 1:
				System.out.println("Introduce la descripción");
				description = sc.nextLine();
				System.out.println("Introduce la cantidad");
				dinero = sc.nextInt();
				sc.nextLine();
				gasto = new Gasto(dinero, description);
				cuenta.addGastos(description, dinero);
				System.out.println(gasto.toString());
			    break;
			  case 2:
				System.out.println("Introduce la descripción");
				description = sc.nextLine();
				System.out.println("Introduce la cantidad");
				dinero = sc.nextInt();
				sc.nextLine();
				ingreso = new Ingreso(dinero, description);
				cuenta.addIngresos(description, dinero);
				System.out.println(ingreso.toString());
			    break;
			  case 3:
				gastos = cuenta.getGastos();
				for (int i = 0; i < gastos.size(); i++) {
					System.out.println(gastos.get(i).toString());
				}
			    break;
			  case 4:
				ingresos = cuenta.getIngresos();
				for (int i = 0; i < ingresos.size(); i++) {
					System.out.println(ingresos.get(i).toString());
				}
			    break;
			    
			  case 5:
				  System.out.println("El saldo actual de la cuenta es: " + cuenta.getSaldo() + "€");
			    break;
			  case 0:
				System.out.println("Fin del programa.\n"
							+ "Gracias por utilizar la aplicación.");
				break;
			  default:
				System.out.println("Lo números válidos son del 0 al 5, ambos incluídos");
			}
			
		} while(number != 0);
		sc.close();
	}
}
