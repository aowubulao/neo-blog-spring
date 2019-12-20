package com.neoniou.blog.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author neo.zzj
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(NeoBlogException.class)
    public ResponseEntity<ExceptionResult> handleException(NeoBlogException e) {
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResponseEntity.status(exceptionEnum.getStatusCode()).body(new ExceptionResult(e.getExceptionEnum()));
    }
}

