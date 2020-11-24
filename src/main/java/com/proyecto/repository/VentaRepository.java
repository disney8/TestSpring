package com.proyecto.repository;

import java.util.List;

import com.proyecto.model.Venta;
import org.springframework.data.repository.CrudRepository;

public interface VentaRepository extends CrudRepository<Venta, Integer> {
	
	public List<Venta> findByIdVenta(Integer idVenta);
	
	
}
