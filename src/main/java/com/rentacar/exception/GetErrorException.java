package com.rentacar.exception;

public class GetErrorException extends RuntimeException {

    private String msg;

    public GetErrorException(String mensaje){
        super(mensaje);
        this.msg = mensaje;
    }

    public String getMsg() {
        return msg;
    }

}
