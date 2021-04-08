public class GastoException extends Exception {
	String sms;
	 
	public GastoException() {
		this.sms = "No hay saldo suficiente";
	}
	 @Override
	 public String getMessage (){
		 return sms;
	 }
}
