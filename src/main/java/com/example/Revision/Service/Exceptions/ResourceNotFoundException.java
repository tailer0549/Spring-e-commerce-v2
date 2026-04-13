package com.example.Revision.Service.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    // Subclasse de Runtime exception
    /*
    * A nossa camada de serviço deve ser capaz de lançar suas próprias exceções e não deixar vazar exceções diversas*/
    // Essa é a nossa exceção personalizada..


    // Id do objeto que nós tentamos encontrar, mas não conseguimos..
    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
