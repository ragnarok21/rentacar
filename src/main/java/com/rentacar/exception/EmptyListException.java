package com.rentacar.exception;

public class EmptyListException extends RuntimeException {

    private String msg;

    public EmptyListException(String mensaje){
        super(mensaje);
        this.msg = mensaje;
    }

    public String getMsg() {
        return msg;
    }

}
