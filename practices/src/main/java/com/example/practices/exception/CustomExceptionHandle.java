package com.example.practices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandle  {


    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> onConstraintValidationException(HttpServletRequest request, ConstraintViolationException ex) {
     // String exceptionResponse = String.format("Invalid input parameters: %s\n", ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
   }

      @ExceptionHandler(MethodArgumentNotValidException.class)
      protected ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
          List<String> details = new ArrayList<>();
          for(ObjectError error : ex.getBindingResult().getAllErrors()) {
              details.add(error.getDefaultMessage());
          }
          ErrorResponse error = new ErrorResponse("Validation Failed", details);
          return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
      }


    @ExceptionHandler(Exception.class) // exception handled
    public ResponseEntity<ErrorResponse> handleExceptions(Exception ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Internal Error ", details);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
