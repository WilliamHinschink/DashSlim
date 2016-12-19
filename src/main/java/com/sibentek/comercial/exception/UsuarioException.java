package com.sibentek.comercial.exception;

/**
 *
 * @author WILLIAM
 */
public class UsuarioException extends AppException{

    @Override
    public Integer code() {
        return null;
    }

    @Override
    public String message() {
        return "Erro ao carregar usuário";
    }
    
}
