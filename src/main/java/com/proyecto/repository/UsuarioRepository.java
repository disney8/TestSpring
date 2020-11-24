package com.proyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.model.User;

public interface UsuarioRepository extends CrudRepository<User, Integer> {

	public List<User> findByNombreUsuario(String nombreUsuario);
    
}
