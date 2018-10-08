package it.ilpirris.exception;

import it.ilpirris.exception.spec.CustomException;

public class NotEnoughMoneyException extends CustomException
{

	private static final long serialVersionUID = -3949703260527453238L;
	
	private String message = "NOT ENOUGH MONEY";

	@Override
	public String getMessage() {
		return this.message;
	}
}
