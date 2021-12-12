package com.aninfo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class ProyectoFinalizadoException extends RuntimeException{

    public ProyectoFinalizadoException(String message) {
        super(message);
    }
}
