package com.proyecto.repository;


import java.util.List;

import com.proyecto.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

	public List<Cliente> findByNombre(String nombre);
    
}