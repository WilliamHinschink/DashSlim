package com.sibentek.comercial.exception;

/**
 *
 * @author WILLIAM
 */
public abstract class AppException extends RuntimeException{
    
    public abstract Integer code();
    
    public abstract String message();
}
