package com.infoplusvn.ctm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by https://github.com/kwanpham
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LogicException extends Exception{
    private static final long serialVersionUID = 1L;
    public LogicException(String message){
        super(message);
    }
}
