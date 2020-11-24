package com.proyecto.controller;

import java.net.URISyntaxException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.model.Cliente;
import com.proyecto.model.DetalleVenta;
import com.proyecto.model.Venta;
import com.proyecto.service.ClienteService;
import com.proyecto.service.DetalleVentaService;
import com.proyecto.service.ProductoService;
import com.proyecto.service.VentaService;

@RestController
@RequestMapping("/api")
public class VentaController {
	
	  @Autowired
	  private VentaService ventaService;
	  @Autowired
	  private DetalleVentaService detalleventaService;
	  @Autowired
	  private ClienteService clienteService;
	  
	  @Autowired
	  private ProductoService ProcutoService;
	
	 @RequestMapping(value="/venta", method=RequestMethod.GET)
	    public Venta getVentaId(){			   
		    return new Venta(1L, new Cliente(1L, "DisneyCliente", "Lopez", "52813413", "Disney@gmail.com"), null);		   
	    }
	 
	 @RequestMapping(value="/add", method=RequestMethod.POST)
		public Venta addProduct(@RequestParam(value="idProducto") Integer idProducto, @RequestParam(value="qty", defaultValue="1") int quantity, 
								   @RequestParam(value="user", defaultValue="anonymous") String username)
		{
			return detalleventaService.addProduct(idProducto,  username);
		}
	
	 
	    @RequestMapping(value = "/Client/{idCliente}/venta/{idVenta}", method = RequestMethod.PUT)
		public @ResponseBody ResponseEntity<Void> addProduct(@PathVariable("idVenta") Long idCart, @RequestParam("idProduct") Long idProduct,
				@RequestParam("quantity") Integer quantity) {
			ventaService.add(idCart, idProduct, quantity);			
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		
	    // Adicionar al carrito  creando una venta y un detalle de venta
		@RequestMapping(value = "/addventa", method = RequestMethod.POST)
		public @ResponseBody ResponseEntity<Void> ordered(@PathVariable("idCliente") Integer idCliente, @PathVariable("idproducto") Integer idproducto , HttpServletRequest request) throws URISyntaxException {
			Venta venta = new Venta();
			venta.setCliente(clienteService.findClient(idCliente).get());
			Timestamp tstamp = new Timestamp(System.currentTimeMillis());
			venta.setFecha(tstamp);
			Venta var = null;
			try {
				var = ventaService.createVenta(venta);				
				if(var!=null) {
					DetalleVenta detalleventa= new DetalleVenta();
					detalleventa.setProductos(ProcutoService.findProducto(idproducto).get());
					detalleventa.setVenta(var);
					detalleventaService.createDetalleVenta(detalleventa);					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}

}
