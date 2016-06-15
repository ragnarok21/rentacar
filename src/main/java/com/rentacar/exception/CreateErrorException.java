package com.rentacar.exception;

public class CreateErrorException extends RuntimeException {

    private String msg;

    public CreateErrorException(String mensaje){
        super(mensaje);
        this.msg = mensaje;
    }

    public String getMsg() {
        return msg;
    }

}
