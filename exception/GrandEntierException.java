package exception;

public class GrandEntierException extends Exception{
	
	public GrandEntierException(){
		super("coucou");
	}
	
	public GrandEntierException(String message){
		super(message);
	}

}
