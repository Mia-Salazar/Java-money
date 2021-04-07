public class GastoException extends Exception {
	String sms;
	 
	public GastoException() {
		this.sms = "";
	}
	 @Override
	 public String getMessage (){
		 return sms;
	 }
}
