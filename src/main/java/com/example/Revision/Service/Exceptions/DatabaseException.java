package com.example.Revision.Service.Exceptions;

public class DatabaseException extends RuntimeException {
    // Subclasse de RuntimeException
    // Capturar o segundo catch do UserService (delete), erro ao deletar um id linkado a um pedido
    public DatabaseException(String msg) {
        super(msg);
    }
}
