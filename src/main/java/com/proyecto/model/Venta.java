package com.proyecto.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import com.proyecto.model.DetalleVenta;

@Entity
@Table(name="venta")
public class Venta {
	
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer idVenta;
	    
	    @ManyToOne
		@JoinColumn(name = "idCliente")	
		private Cliente cliente;
	    
	    private Timestamp fecha;
	    
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
	    private List<DetalleVenta> listaDetalleVenta;
	    
	    public Venta() {
			
			
		}
	    
	    public Venta(long l, Cliente cliente, Timestamp fecha) {
			// TODO Auto-generated constructor stub
			super();
			this.idVenta = idVenta;
			this.cliente = cliente;
			this.fecha = fecha;
			
		}

		public Integer getIdVenta() {
			return idVenta;
		}

		public void setIdVenta(Integer idVenta) {
			this.idVenta = idVenta;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Timestamp getFecha() {
			return fecha;
		}

		public void setFecha(Timestamp fecha) {
			this.fecha = fecha;
		}

		public List<DetalleVenta> getListaDetalleVenta() {
			return listaDetalleVenta;
		}

		public void setListaDetalleVenta(List<DetalleVenta> listaDetalleVenta) {
			this.listaDetalleVenta = listaDetalleVenta;
		}


}
