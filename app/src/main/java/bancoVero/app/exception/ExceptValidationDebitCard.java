package bancoVero.app.exception;

@SuppressWarnings("serial")
public class ExceptValidationDebitCard extends RuntimeException{
	public ExceptValidationDebitCard(String message) {
        super(message);
    }

}
