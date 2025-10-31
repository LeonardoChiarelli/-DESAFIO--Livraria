package br.com.LeoChiarelli.Livraria.application;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
