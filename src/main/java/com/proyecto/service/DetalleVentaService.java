package com.proyecto.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Cliente;
import com.proyecto.model.DetalleVenta;
import com.proyecto.model.Producto;
import com.proyecto.model.Venta;
import com.proyecto.repository.ClienteRepository;
import com.proyecto.repository.DetalleVentaRepository;
import com.proyecto.repository.ProductoRepository;
import com.proyecto.repository.VentaRepository;
import com.proyecto.util.ProductNotFoundException;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleventaRepository;
    @Autowired
    private ProductoRepository productRepository;


    public List<DetalleVenta> getAllDetalleVentas() {
        List<DetalleVenta> ventas = new ArrayList<>();
        detalleventaRepository.findAll().forEach(ventas::add);
        return ventas;

    }
    
    public Optional<DetalleVenta> findDetalleVenta(Integer id) {
        return detalleventaRepository.findById(id);

    }

    public Boolean createDetalleVenta(DetalleVenta detalleventa){
        try{
        	       	     	
        	detalleventaRepository.save(detalleventa);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

	public Venta addProduct(Integer idProducto, String username)   {
		// TODO Auto-generated method stub
		DetalleVenta detalleVenta;
		List<Producto> foundProducts = productRepository.findByIdProducto(idProducto);
		if (foundProducts.size() != 0) {
			throw new ProductNotFoundException();
    	}
		// Is product already in the cart?
    	Producto product = foundProducts.get(0);
    	/* List<CartItem> foundItems = cartItemRepository.findByProduct(product);
    	CartItem cartItem;
    	if (foundItems.size() > 0) {
    		// yes, increment count 
    		cartItem = foundItems.get(0);
    		cartItem.setQuantity(cartItem.getQuantity() + quantity);
    	} else {
    		// not yet, add a new product
    		cartItem = new CartItem(foundProducts.get(0), quantity);
    	}
		return cartItemRepository.save(cartItem);	*/	
    	return null;
	}

   
}