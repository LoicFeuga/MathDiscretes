package exception;

public class IntegerNotInBaseException extends Exception{
	private final static String MESSAGE = "[ERROR] Integer not in base ";
	
	public IntegerNotInBaseException(){
		super(MESSAGE);
	}
	
	public IntegerNotInBaseException(String message)
    {
       super(message);
    }
	
	public IntegerNotInBaseException(Integer in, int base){
		super("[ERROR] Integer "+in +" not contains in base "+base);
	}

}
