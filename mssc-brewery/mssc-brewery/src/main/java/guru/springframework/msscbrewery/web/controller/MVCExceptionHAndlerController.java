package guru.springframework.msscbrewery.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MVCExceptionHAndlerController {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
		List<String> errors = new ArrayList<String>(e.getConstraintViolations().size());
		e.getConstraintViolations().forEach(constraintViolationException -> {
			errors.add(constraintViolationException.getPropertyPath() + ":" + constraintViolationException.getMessage());
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BindException.class)
	public ResponseEntity<List> handleBindException(BindException e) {
		return new ResponseEntity(e.getAllErrors(), HttpStatus.BAD_REQUEST);
	}

}
