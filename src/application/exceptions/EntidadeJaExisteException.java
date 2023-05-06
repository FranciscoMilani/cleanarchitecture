package application.exceptions;

@SuppressWarnings("serial")
public class EntidadeJaExisteException extends RuntimeException {
	public EntidadeJaExisteException(String entidade) {
		super(entidade);
	}
}
