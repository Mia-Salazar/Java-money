import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Declaramos las variables necesarias
		String nombre;
		String edad;
		String DNI;
		Usuario usuario;
		Cuenta cuenta;
		//Creamos el lector
		Scanner sc = new Scanner(System.in);
		//Creamos uan instancia del usuario
		usuario = new Usuario();
		
		//Pedimos al usuario el nombre
		System.out.println("Introduce el nombre del usuario");
		nombre = sc.nextLine();
	    while (nombre == "") {
	    	//La petición del nombre continuará siempre y cuando esté vacío
			System.out.println("Nombre introducido incorrecto");
	        System.out.println("Introduce el Nombre del usuario válido");
	        nombre = sc.nextLine();
	    }
	    //Aañadimos el nombre al usuario
		usuario.setNombre(nombre);
		//Pedimos al usuario su edad
		System.out.println("Introduce la edad del usuario");
		do {
			//Si introducen un valor que no es un valor numérico, seguirá pidiendo la edad hasta que pongan un valor válido
		    try {
		    	int edadNueva;
				edad = sc.nextLine();
				edadNueva = Integer.parseInt(edad);
				//Aañadimos la edad al usuario
		    	usuario.setEdad(edadNueva);
		    } catch (NumberFormatException error) {
				System.out.println("Edad introducida incorrecta");
		        System.out.println("Introduce la edad del usuario válida");
		    }
		} while (usuario.getEdad() == 0);
		
		//Pedimos el DNI al usuario
		System.out.println("Introduce el DNI del usuario");
		DNI = sc.nextLine();
		//Mientras que el DNI no sea válido, seguirá pidiéndolo indicándole que es erróneo, si es correcto, añadirá el DNI al usuario
	    while (!usuario.setDNI(DNI)) {
			System.out.println("DNI introducido incorrecto");
	        System.out.println("Introduce el DNI del usuario válido");
	 		DNI = sc.nextLine();
	    }
	    //Inicializamos la cuenta con el usuario y lo indicamos
	    cuenta = new Cuenta(usuario);
	    System.out.println("Usuario creado correctamente");
	    //Iniciamos el menu
	    menu(cuenta);
	    //Cerramos el Scanner
	    sc.close();
		
	}
	
	public static void menu(Cuenta cuenta) {
		//Declaramos las variables necesarias
		int number;
		String dinero;
		String description;
		Scanner sc = new Scanner(System.in);
		ArrayList<Gasto> gastos;
		ArrayList<Ingreso> ingresos;
		//Repetimos el menú hasta que se introduzca el 0
		do {
			System.out.println("Realiza una nueva acción\n"
					+ "1 Introduce un nuevo gasto\n"
					+ "2 Introduce un nuevo ingreso\n"
					+ "3 Mostrar gastos\n"
					+ "4 Mostrar ingresos\n"
					+ "5 Mostrar saldo\n"
					+ "0 Salir");
			//Pedimos un número por pantalla que será el que usemos para continuar en el bucle
			number = sc.nextInt();
			sc.nextLine();
			switch(number) {
			  case 1:
				double cantidadGasto = 0;
				System.out.println("Introduce la descripción");
				description = sc.nextLine();
				do {
					//Si la cantidad introducida no es un número, le avisará de que solo puede introducir un número
				    try {
						System.out.println("Introduce la cantidad");
						dinero = sc.nextLine();
						cantidadGasto = Double.parseDouble(dinero);
						cuenta.addGastos(description, cantidadGasto);
				    } catch (NumberFormatException error) {
						System.out.println("La cantidad solo puede ser un valor numérico");
				    }
				} while (cantidadGasto == 0);
				System.out.println("Saldo restante: " + cuenta.getSaldo());
			    break;
			  case 2:
				double cantidadIngreso = 0;
				System.out.println("Introduce la descripción");
				description = sc.nextLine();
				do {
					//Si la cantidad introducida no es un número, le avisará de que solo puede introducir un número
				    try {
						System.out.println("Introduce la cantidad");
						dinero = sc.nextLine();
						cantidadIngreso = Double.parseDouble(dinero);
						cuenta.addIngresos(description, cantidadIngreso);
				    } catch (NumberFormatException error) {
						System.out.println("La cantidad solo puede ser un valor numérico");
				    }
				} while (cantidadIngreso == 0);
				System.out.println("Saldo restante: " + cuenta.getSaldo() + "€");
			    break;
			  case 3:
				//Mostramos la lista de Gastos
				gastos = cuenta.getGastos();
				for (int i = 0; i < gastos.size(); i++) {
					System.out.println(gastos.get(i).toString());
				}
			    break;
			  case 4:
				 //Mostramos la lista de Ingresos
				ingresos = cuenta.getIngresos();
				for (int i = 0; i < ingresos.size(); i++) {
					System.out.println(ingresos.get(i).toString());
				}
			    break;
			    
			  case 5:
				  //Mostramos el saldo
				  System.out.println("El saldo actual de la cuenta es: " + cuenta.getSaldo() + "€");
			    break;
			  case 0:
				  //Si introducen el 0 finalizamos el programa
				System.out.println("Fin del programa.\n"
							+ "Gracias por utilizar la aplicación.");
				break;
			  default:
				  //Si introduce cualquier valor que no sea del 0 al 5, le avisará
				System.out.println("Lo números válidos son del 0 al 5, ambos incluídos");
			}
			
		} while(number != 0);
		//Cerramos el Scanner
		sc.close();
	}
}
