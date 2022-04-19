package com.bolsaideas.springboot.backend.apirest.model.service;

import com.bolsaideas.springboot.backend.apirest.model.entity.Usuario;

public interface iUsuarioService {
    public Usuario findByUsername(String username);
}
