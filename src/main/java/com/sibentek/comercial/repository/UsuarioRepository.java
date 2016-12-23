package com.sibentek.comercial.repository;

import com.sibentek.comercial.model.Usuario;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author WILLIAM
 */
public class UsuarioRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Usuario porId(Long id) {
        return this.manager.find(Usuario.class, id);
    }

    public Usuario porEmail(String email) {
        Usuario usuario = null;

        try {
            usuario = this.manager.createQuery("from Usuario where lower(email) = :email", Usuario.class)
                    .setParameter("email", email.toLowerCase()).getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        return usuario;
    }
    
    public Usuario salvar(Usuario usuario){
        return manager.merge(usuario);
    }

}
