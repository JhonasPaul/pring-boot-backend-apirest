package com.bolsaideas.springboot.backend.apirest.model.repository;

import com.bolsaideas.springboot.backend.apirest.model.entity.Usuario;

import org.springframework.data.repository.CrudRepository;

/*seguridad[3]*/
public interface iUsuarioRepository extends CrudRepository<Usuario, Long> {
    public Usuario findByUsername(String username);

//    @Query("select u from Usuario u where u.username=?1")
//    public Usuario findByUsername(String username);
}
