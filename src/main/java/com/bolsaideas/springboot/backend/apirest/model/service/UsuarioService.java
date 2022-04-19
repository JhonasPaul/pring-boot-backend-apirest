package com.bolsaideas.springboot.backend.apirest.model.service;

import com.bolsaideas.springboot.backend.apirest.model.entity.Usuario;
import com.bolsaideas.springboot.backend.apirest.model.repository.iUsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/*seguridad[4]*/
@Service
public class UsuarioService implements iUsuarioService, UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    private iUsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsername(username);
        if (usuario == null) {
            logger.error("Error en el login: no existe el usuari on " + username + " en el sistema");
            throw  new UsernameNotFoundException("Error en el login: no exite el usuario " + username + "  el sistema");
        }
        /*convertir la lsita de roles a un tipo collection del tipo SimpleGrantedAuthority*/
        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(),true,true,true, authorities);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
