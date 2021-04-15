public class GastoException extends Exception {
	public GastoException() {
		//Devolvemos el mensaje de error
		super("No hay saldo suficiente\n");
	}
}
