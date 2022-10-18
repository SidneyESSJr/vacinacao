package br.com.vacinacao.backend.services.exceptions;

public class ObjectNotFoudException extends RuntimeException {

    public ObjectNotFoudException(String arg0) {
        super(arg0);
    }

    public ObjectNotFoudException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
    
}
