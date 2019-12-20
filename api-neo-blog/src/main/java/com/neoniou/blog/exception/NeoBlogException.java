package com.neoniou.blog.exception;

/**
 * @author neo.zzj
 */
public class NeoBlogException extends RuntimeException{

    private ExceptionEnum exceptionEnum;

    public NeoBlogException() {
    }

    public NeoBlogException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public NeoBlogException(String message, Throwable cause, ExceptionEnum exceptionEnum) {
        super(message, cause);
        this.exceptionEnum = exceptionEnum;
    }

    public NeoBlogException(Throwable cause, ExceptionEnum exceptionEnum) {
        super(cause);
        this.exceptionEnum = exceptionEnum;
    }

    protected NeoBlogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ExceptionEnum exceptionEnum) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }
}
