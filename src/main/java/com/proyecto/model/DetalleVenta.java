package com.proyecto.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.model.Venta;
import com.proyecto.model.Producto;

@Entity
@Table(name="detalleVenta")
public class DetalleVenta {
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDetalleVenta;
    
    @ManyToOne
	@JoinColumn(name = "idProducto")	
	private Producto productos;
    
    //cada compra debe tener la cantidad de productos
    private Integer cantidad;
    
    public DetalleVenta() {
		
		
	}
    
    @ManyToOne
   	@JoinColumn(name = "idVenta")	
   	private Venta venta;
    

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Integer idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}    

    
    
}
