package exp;

public class ResourceAccessException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceAccessException(String mess , Throwable e) {
		super(mess,e);
	}
}
