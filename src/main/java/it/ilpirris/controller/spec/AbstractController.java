package it.ilpirris.controller.spec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import it.ilpirris.exception.spec.CustomException;

public abstract class AbstractController {

	Logger logger = LogManager.getLogger();

	
	@ExceptionHandler(CustomException.class)
	@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE)
	public String handleException(CustomException e){
		logger.error(e.getClass());
		return e.getMessage();
	}
}
