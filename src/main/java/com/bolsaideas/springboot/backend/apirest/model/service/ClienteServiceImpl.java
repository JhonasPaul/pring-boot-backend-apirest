package com.bolsaideas.springboot.backend.apirest.model.service;

import com.bolsaideas.springboot.backend.apirest.model.entity.Cliente;
import com.bolsaideas.springboot.backend.apirest.model.entity.Region;
import com.bolsaideas.springboot.backend.apirest.model.repository.iClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements iClienteService{
    @Autowired
    iClienteRepository repository;

    @Override
    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    @Override
    public Page<Cliente> listarClientes(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Cliente agregarCliente(Cliente idcliente) {
        return repository.save(idcliente);
    }

    @Override
    public Cliente listarClientePorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminarCliente(Long id) {
        repository.deleteById(id);
    }

    /*listar Region*/
    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return repository.findAllRegiones();
    }
}
