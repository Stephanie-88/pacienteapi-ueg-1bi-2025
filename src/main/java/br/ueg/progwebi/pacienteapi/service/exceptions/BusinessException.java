package br.ueg.progwebi.pacienteapi.service.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message, Throwable e){
        super(message, e);
    }

    public BusinessException(String message){
        super(message);
    }
}
