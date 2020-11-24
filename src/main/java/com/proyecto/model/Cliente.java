package com.proyecto.model;

import javax.persistence.*;

import java.io.Serializable;


/**
 * The persistent class for the coments database table.
 * 
 */
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {

	  /**
		 * 
		 */
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCliente;

      
    private String nombre;
    
    private String apellido;

    private String telefono;
    
    private String email;

    public Cliente(){

    }
	public Cliente(long l, String nombre, String apellido, String telefono, String email) {
		// TODO Auto-generated constructor stub
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
	}

	public Integer getIdcliente() {
		return idCliente;
	}

	public void setIdcliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

   
		
}