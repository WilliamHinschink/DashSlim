package com.sibentek.comercial.service;

import com.sibentek.comercial.model.Usuario;
import com.sibentek.comercial.repository.UsuarioRepository;
import com.sibentek.comercial.util.jpa.Transacional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author william
 */
public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioRepository usuarios;

    @Transacional
    public void salvar(Usuario usuario) {
        usuarios.salvar(usuario);
    }

    public String refactorLoginName(String name) {
        String[] nameReturn = name.split(" ");
        String firstName = nameReturn[0].substring(0);
        char lastname = nameReturn[1].charAt(0);
        String nameReturnOrigin = firstName + lastname;
        return nameReturnOrigin;
    }
}
