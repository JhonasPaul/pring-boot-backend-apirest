package com.bolsaideas.springboot.backend.apirest.model.service;

import com.bolsaideas.springboot.backend.apirest.model.entity.Cliente;

import com.bolsaideas.springboot.backend.apirest.model.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface iClienteService {
    public List<Cliente>listarClientes();
/*paginacion*/
    public Page<Cliente> listarClientes(Pageable pageable);


    public Cliente agregarCliente(Cliente cliente);
    public Cliente listarClientePorId(Long  id);
    public void eliminarCliente(Long id_cliente);


    public List<Region>findAllRegiones();
}
