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
	    	//La petici�n del nombre continuar� siempre y cuando est� vac�o
			System.out.println("Nombre introducido incorrecto");
	        System.out.println("Introduce el Nombre del usuario v�lido");
	        nombre = sc.nextLine();
	    }
	    //Aa�adimos el nombre al usuario
		usuario.setNombre(nombre);
		//Pedimos al usuario su edad
		System.out.println("Introduce la edad del usuario");
		do {
			//Si introducen un valor que no es un valor num�rico, seguir� pidiendo la edad hasta que pongan un valor v�lido
		    try {
		    	int edadNueva;
				edad = sc.nextLine();
				edadNueva = Integer.parseInt(edad);
				//Aa�adimos la edad al usuario
		    	usuario.setEdad(edadNueva);
		    } catch (NumberFormatException error) {
				System.out.println("Edad introducida incorrecta");
		        System.out.println("Introduce la edad del usuario v�lida");
		    }
		} while (usuario.getEdad() == 0);
		
		//Pedimos el DNI al usuario
		System.out.println("Introduce el DNI del usuario");
		DNI = sc.nextLine();
		//Mientras que el DNI no sea v�lido, seguir� pidi�ndolo indic�ndole que es err�neo, si es correcto, a�adir� el DNI al usuario
	    while (!usuario.setDNI(DNI)) {
			System.out.println("DNI introducido incorrecto");
	        System.out.println("Introduce el DNI del usuario v�lido");
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
		//Repetimos el men� hasta que se introduzca el 0
		do {
			System.out.println("Realiza una nueva acci�n\n"
					+ "1 Introduce un nuevo gasto\n"
					+ "2 Introduce un nuevo ingreso\n"
					+ "3 Mostrar gastos\n"
					+ "4 Mostrar ingresos\n"
					+ "5 Mostrar saldo\n"
					+ "0 Salir");
			//Pedimos un n�mero por pantalla que ser� el que usemos para continuar en el bucle
			number = sc.nextInt();
			sc.nextLine();
			switch(number) {
			  case 1:
				double cantidadGasto = 0;
				System.out.println("Introduce la descripci�n");
				description = sc.nextLine();
				do {
					//Si la cantidad introducida no es un n�mero, le avisar� de que solo puede introducir un n�mero
				    try {
						System.out.println("Introduce la cantidad");
						dinero = sc.nextLine();
						cantidadGasto = Double.parseDouble(dinero);
						cuenta.addGastos(description, cantidadGasto);
				    } catch (NumberFormatException error) {
						System.out.println("La cantidad solo puede ser un valor num�rico");
				    }
				} while (cantidadGasto == 0);
				System.out.println("Saldo restante: " + cuenta.getSaldo());
			    break;
			  case 2:
				double cantidadIngreso = 0;
				System.out.println("Introduce la descripci�n");
				description = sc.nextLine();
				do {
					//Si la cantidad introducida no es un n�mero, le avisar� de que solo puede introducir un n�mero
				    try {
						System.out.println("Introduce la cantidad");
						dinero = sc.nextLine();
						cantidadIngreso = Double.parseDouble(dinero);
						cuenta.addIngresos(description, cantidadIngreso);
				    } catch (NumberFormatException error) {
						System.out.println("La cantidad solo puede ser un valor num�rico");
				    }
				} while (cantidadIngreso == 0);
				System.out.println("Saldo restante: " + cuenta.getSaldo() + "�");
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
				  System.out.println("El saldo actual de la cuenta es: " + cuenta.getSaldo() + "�");
			    break;
			  case 0:
				  //Si introducen el 0 finalizamos el programa
				System.out.println("Fin del programa.\n"
							+ "Gracias por utilizar la aplicaci�n.");
				break;
			  default:
				  //Si introduce cualquier valor que no sea del 0 al 5, le avisar�
				System.out.println("Lo n�meros v�lidos son del 0 al 5, ambos inclu�dos");
			}
			
		} while(number != 0);
		//Cerramos el Scanner
		sc.close();
	}
}
