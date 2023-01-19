package bancoVero.app.exception;

@SuppressWarnings("serial")
public class ExceptValidationBankAccount extends RuntimeException{
	
	public  ExceptValidationBankAccount(String message) {
        super(message);
    };

}
