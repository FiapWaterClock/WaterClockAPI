package br.com.waterclock.api.exception;

public class PasswordException extends Exception {
    public PasswordException(String errorMessage) {
        super(errorMessage);
    }
}
