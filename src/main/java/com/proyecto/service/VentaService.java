package com.proyecto.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Cliente;
import com.proyecto.model.Producto;
import com.proyecto.model.Venta;
import com.proyecto.repository.ClienteRepository;
import com.proyecto.repository.ProductoRepository;
import com.proyecto.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;


    public List<Venta> getAllVentas() {
        List<Venta> ventas = new ArrayList<>();
        ventaRepository.findAll().forEach(ventas::add);
        return ventas;

    }
    
    public Optional<Venta> findVenta(Integer id) {
        return ventaRepository.findById(id);

    }

    public Venta createVenta(Venta venta) throws Exception{
        try{
        	return ventaRepository.save(venta);
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean deleteVentaRecord(Integer id){
        try{
        	ventaRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    public boolean updateVentaRecord(Venta venta, Integer ventaId){
        try{
        	ventaRepository.save(venta);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    
	public void add(Long idCart, Long idProduct, Integer quantity) {
		// TODO Auto-generated method stub
		
	}




}