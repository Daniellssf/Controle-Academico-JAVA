public class NomeInvalidoException extends Exception{
	
	public NomeInvalidoException() {
		
	}
	
	public NomeInvalidoException (String message) {
		super("O nome " + message + " est� incorreto. Informe um nome v�lido");
	}

}
