package be.iccbxl.poo;

public class InvalidDateException extends RuntimeException {
	
	  public InvalidDateException() {
	        super("La date est invalide.");
	    }

	    public InvalidDateException(String message) {
	        super(message);
	    }

}
