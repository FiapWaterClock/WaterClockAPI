package br.com.waterclock.api.exception;

public class EmailExistsException extends Exception {
    public EmailExistsException(String errorMessage) {
        super(errorMessage);
    }
}
