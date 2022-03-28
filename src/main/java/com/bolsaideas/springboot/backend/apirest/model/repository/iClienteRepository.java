package com.bolsaideas.springboot.backend.apirest.model.repository;

import com.bolsaideas.springboot.backend.apirest.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iClienteRepository extends JpaRepository<Cliente, Long> {
}
