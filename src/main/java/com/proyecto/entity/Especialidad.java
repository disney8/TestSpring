package com.proyecto.entity;

public class Especialidad {
	 Long id;
	 String nameespecialidad;
	 
	 
	 public Especialidad(Long id, String nameespecialidad) {
		super();
		this.id = id;
		this.nameespecialidad = nameespecialidad;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameespecialidad() {
		return nameespecialidad;
	}
	public void setNameespecialidad(String nameespecialidad) {
		this.nameespecialidad = nameespecialidad;
	}
	 

}
