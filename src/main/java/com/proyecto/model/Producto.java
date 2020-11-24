package com.proyecto.model;

import javax.persistence.*;

@Entity
@Table(name="producto")
public class Producto {
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProducto;
    
    private String nombre;
    
    private Float precio;
    
    public Producto(){

    }
    
	public Producto(Long l, String nombre, Float precio) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
	}

	
	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
    

}
