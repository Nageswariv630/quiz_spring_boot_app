package org.jsp.question.exceptionhandler;

import org.jsp.question.exceptionclasses.InvalidQuestionIdException;
import org.jsp.question.exceptionclasses.NoQuestionFoundException;
import org.jsp.question.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuestionExceptionHandler {
	@ExceptionHandler(NoQuestionFoundException.class)
	public ResponseEntity<?>noQuestionFoundExceptionHandler(NoQuestionFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).
				body(ResponseStructure.builder().
						httpStatus(HttpStatus.NOT_FOUND.value()).
						message("No question Found in the Database").
						body("No questions present in database").build());
		
	}
	@ExceptionHandler(InvalidQuestionIdException.class)
	public ResponseEntity<?>InvalidQuestionIdExceptionHandler(InvalidQuestionIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).
				body(ResponseStructure.builder().
						httpStatus(HttpStatus.NOT_FOUND.value()).
						message("invalid question id").
						body("invalid question").build());

}
}
