package com.proyecto.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Cliente;
import com.proyecto.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> getAllClients() {

        List<Cliente> Clients = new ArrayList<>();
        clienteRepository.findAll().forEach(Clients::add);
        return Clients;

    }

    public Optional<Cliente> findClient(Integer id) {
        return clienteRepository.findById(id);

    }

    public Boolean createClient(Cliente client){
        try{
            clienteRepository.save(client);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    public boolean deleteClientRecord(Integer id){
        try{
            clienteRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    public boolean updateClientRecord(Cliente client, Integer clientId){
        try{
            clienteRepository.save(client);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }




}