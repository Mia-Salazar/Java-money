import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String nombre;
		String edad;
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
		    	int edadNueva;
				edad = sc.nextLine();
				edadNueva = Integer.parseInt(edad);
		    	usuario.setEdad(edadNueva);
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
		String dinero;
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
					+ "5 Mostrar saldo\n"
					+ "0 Salir");
			number = sc.nextInt();
			sc.nextLine();
			switch(number) {
			  case 1:
				double cantidadGasto = 0;
				System.out.println("Introduce la descripción");
				description = sc.nextLine();
				do {
				    try {
						System.out.println("Introduce la cantidad");
						dinero = sc.nextLine();
						cantidadGasto = Double.parseDouble(dinero);
						gasto = new Gasto(cantidadGasto, description);
						cuenta.addGastos(description, cantidadGasto);
						System.out.println(gasto.toString());
				    } catch (NumberFormatException error) {
						System.out.println("La cantidad solo puede ser un valor numérico");
				    }
				} while (cantidadGasto == 0);

			    break;
			  case 2:
				double cantidadIngreso = 0;
				System.out.println("Introduce la descripción");
				description = sc.nextLine();
				do {
				    try {
						System.out.println("Introduce la cantidad");
						dinero = sc.nextLine();
						cantidadIngreso = Double.parseDouble(dinero);
						ingreso = new Ingreso(cantidadIngreso, description);
						cuenta.addIngresos(description, cantidadIngreso);
						System.out.println(ingreso.toString());
				    } catch (NumberFormatException error) {
						System.out.println("La cantidad solo puede ser un valor numérico");
				    }
				} while (cantidadIngreso == 0);
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
