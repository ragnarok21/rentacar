package com.rentacar.exception;

public class DeleteErrorException extends RuntimeException {

    private String msg;

    public DeleteErrorException(String mensaje){
        super(mensaje);
        this.msg = mensaje;
    }

    public String getMsg() {
        return msg;
    }

}
