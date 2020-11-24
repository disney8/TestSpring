package com.proyecto.entity;

public class Persona{	
		 Long id;
		 String nombre;
		 String apellidos;
		 String telefono;
		 String correo;
		
		
		public Persona(Long id, String nombre, String apellidos, String telefono, String correo) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.telefono = telefono;
			this.correo = correo;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getApellidos() {
			return apellidos;
		}


		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


		public String getCorreo() {
			return correo;
		}


		public void setCorreo(String correo) {
			this.correo = correo;
		}
			

}
