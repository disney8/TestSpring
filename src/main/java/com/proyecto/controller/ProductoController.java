package com.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.model.Producto;
import com.proyecto.service.ClienteService;
import com.proyecto.service.ProductoService;


@RestController
@RequestMapping("/api")
public class ProductoController {
	
	  @Autowired
	    private ProductoService productoService;
		 
	   @RequestMapping(value="/producto", method=RequestMethod.GET)
	    public Producto getProductoId(){			   
		    return new Producto(1L, "Producto1", new Float(3));		   
	    }
	   	   
	   @RequestMapping(value="/productDetails", method = RequestMethod.GET)
	    public Optional getClient(@RequestParam("id") Integer id) {
	        return productoService.findProducto(id);
	    }
	   
	   @RequestMapping(value="/productos", method= RequestMethod.GET)
	    public List getAllProductos() {
	        return productoService.getAllProductos();
	    }

	    @RequestMapping(value="/productCreate", method = RequestMethod.POST)
	    public void createProducto(@RequestBody Producto producto) {
	    	productoService.createProducto(producto);
	    }

	    @RequestMapping(value="/productDelete", method = RequestMethod.DELETE)
	    public void deleteProducto(@RequestParam("id") Integer id) {
	    	productoService.deleteProductoRecord(id);
	    }

	    @RequestMapping(value="/productUpdate", method = RequestMethod.PUT)
	    public void updateProducto(@RequestBody Producto producto, @RequestParam("id") Integer productId) {
	    	productoService.updateProductRecord(producto, productId);
	    }

}
