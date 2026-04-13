package com.example.Revision.Controller.Exceptions;

import com.example.Revision.Service.Exceptions.DatabaseException;
import com.example.Revision.Service.Exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice // Define uma classe global de tratamento de exceções..
public class ResourceExceptionHandler {

    /*
    ControllerAdivice -> Intercepta as exceções que acontecerem para o ResourceExceptionHandler poder executar os tratamentos adequados..
    Exception Handler -> Esse metodo vai interceptar todo tipo de erro que esteja dentro da anotation ExceptionHandler
    */
    @ExceptionHandler(ResourceNotFoundException.class) // ExceptionHandler -> Precisa saber qual tipo tratar
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND; // Status não encontrado..
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); // Mensagem de erro padrão
        return ResponseEntity.status(status).body(err); // Body -> Retornar o nosso erro..
    }

    // Criando um método para DatabaseException

    @ExceptionHandler(DatabaseException.class) // ExceptionHandler -> Precisa saber qual tipo tratar
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String error = "Database error"; // Mensagem padrão
        HttpStatus status = HttpStatus.BAD_REQUEST; //
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); // Mensagem de erro padrão
        return ResponseEntity.status(status).body(err); // Body -> Retornar o nosso erro..
    }

    // Criando um método para tratar exceções globais
    @ExceptionHandler(Exception.class) // Captura todo erro dentro deste método que for do tipo passado como parâmetro para a anotation
    public ResponseEntity<StandardError> generic(Exception e, HttpServletRequest request) {
        String error = "Unexpected error"; // Mensagem de erro padrão
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
