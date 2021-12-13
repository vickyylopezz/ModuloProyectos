package com.aninfo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class TareaFinalizadaException extends RuntimeException{
    public TareaFinalizadaException(String message) {
        super(message);
    }
}
