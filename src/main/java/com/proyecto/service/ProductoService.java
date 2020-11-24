package com.proyecto.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Cliente;
import com.proyecto.model.Producto;
import com.proyecto.repository.ClienteRepository;
import com.proyecto.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public List<Producto> getAllProductos() {
        List<Producto> Products = new ArrayList<>();
        productoRepository.findAll().forEach(Products::add);
        return Products;

    }
    
    public Optional<Producto> findProducto(Integer id) {
        return productoRepository.findById(id);

    }

    public Boolean createProducto(Producto producto){
        try{
        	productoRepository.save(producto);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    public boolean deleteProductoRecord(Integer id){
        try{
        	productoRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    public boolean updateProductRecord(Producto producto, Integer productId){
        try{
        	productoRepository.save(producto);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }




}