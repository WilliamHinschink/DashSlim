package com.sibentek.comercial.security;

import com.sibentek.comercial.exception.UsuarioException;
import com.sibentek.comercial.model.Grupo;
import com.sibentek.comercial.model.Usuario;
import com.sibentek.comercial.repository.UsuarioRepository;
import com.sibentek.comercial.util.cdi.CDIServiceLocator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author WILLIAM
 */
public class AppUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioRepository usuarios = CDIServiceLocator.getBean(UsuarioRepository.class);
        Usuario usuario = usuarios.porEmail(email);

        UsuarioSistema usuarioSistema = null;

        if (usuario == null) {
            throw new UsuarioException();
        }
        usuarioSistema = new UsuarioSistema(usuario, getGrupos(usuario));

        return usuarioSistema;
    }

    private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        usuario.getGrupos().stream().forEach((grupo) -> {
            authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
        });

        return authorities;
    }

}
