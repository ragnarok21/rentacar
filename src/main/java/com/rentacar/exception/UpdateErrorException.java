package com.rentacar.exception;

public class UpdateErrorException extends RuntimeException {

    private String msg;

    public UpdateErrorException(String mensaje){
        super(mensaje);
        this.msg = mensaje;
    }

    public String getMsg() {
        return msg;
    }

}
