package com.sibentek.comercial.controller;

import com.sibentek.comercial.model.Usuario;
import com.sibentek.comercial.service.UsuarioService;
import java.io.Serializable;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author william
 */
@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsuarioService usuarioService;
    private Usuario usuario = new Usuario();
    
    public void salvar(){
        String nomeLogin = usuarioService.refactorLoginName(usuario.getNome());
        usuario.setNomeLogin(nomeLogin);
        usuarioService.salvar(usuario);
    }
    
    public void abreDialogo(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
