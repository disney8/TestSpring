package com.proyecto.repository;

import java.util.List;

import com.proyecto.model.Cliente;
import com.proyecto.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	
	public List<Cliente>  findByNombre(String nombre);
	public List<Producto> findByIdProducto(Integer idProducto);
	
}
