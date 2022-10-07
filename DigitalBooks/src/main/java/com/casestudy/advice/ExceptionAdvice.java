package com.casestudy.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.casestudy.Models.ErrorMessage;
import com.casestudy.exceptions.BookExceptions;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(BookExceptions.class)
	public ResponseEntity<?> handleMovieException(BookExceptions me) {

		return new ResponseEntity<ErrorMessage>(new ErrorMessage("BookException: " + me.getMessage(),
				me.getClass().toString(), "Something bad happened, please try after some time"), HttpStatus.OK);

		// return new ResponseEntity<String>("MovieException: "+me.getMessage(),
		// HttpStatus.OK);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleMovieException(NoSuchElementException me) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("BookException: " + me.getMessage(),
				me.getClass().toString(), "Something bad happened, Item not found"), HttpStatus.NOT_FOUND);
	}

}
