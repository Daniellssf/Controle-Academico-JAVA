public class NomeInvalidoException extends Exception{
	
	public NomeInvalidoException() {
		
	}
	
	public NomeInvalidoException (String message) {
		super("O nome " + message + " está incorreto. Informe um nome válido");
	}

}
