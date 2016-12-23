package com.sibentek.comercial.controller;

import com.sibentek.comercial.model.Usuario;
import com.sibentek.comercial.service.UsuarioService;
import com.sibentek.comercial.util.jsf.FacesUtil;
import java.io.Serializable;
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
    
    private Usuario usuario;
    
    public void salvar(){
        usuarioService.salvar(usuario);
        usuario = new Usuario();
        
        FacesUtil.addInfoMessage("Usuário salvo com sucesso!");
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
