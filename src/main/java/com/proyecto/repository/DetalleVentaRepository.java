package com.proyecto.repository;

import java.util.List;

import com.proyecto.model.DetalleVenta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DetalleVentaRepository extends CrudRepository<DetalleVenta, Integer> {	
	public List<DetalleVenta> findByIdDetalleVenta(Integer idDetalleVenta);	
	
	/*@Query("SELECT  FROM DetalleVenta f ") 
	DetalleVenta findDetalleByClienteByProducto( Integer idproducto, Integer idVenta);*/
}
