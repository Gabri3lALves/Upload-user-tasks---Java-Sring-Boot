package com.primeirospring.todolist.erros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Anotação do Spring utilizado para tratamentos de Erros
@ControllerAdvice 
public class ExceptionHandlerController {
    
    @ExceptionHandler(HttpMessageNotReadableException.class) //Dizer q esse metodo é exatamente para essa exceção
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMostSpecificCause().getMessage()); //Message é a mensagewm
    }
}
