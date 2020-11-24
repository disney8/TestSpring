package com.proyecto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.proyecto.model.Cliente;
import com.proyecto.model.User;
import com.proyecto.service.ClienteService;
import com.proyecto.util.utiles;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping("/api")
public class ClienteController {
	  private static Logger logger; 
	
	  @Autowired
	   private ClienteService clienteService;
	
	 @RequestMapping(value="/clienteEjemplo", method=RequestMethod.GET)
	    public Cliente getClienteId(){			   
		    return new Cliente(1L, "DisneyCliente", "Lopez", "52813413", "Disney@gmail.com");		   
	    }
		
	   @RequestMapping(value="/clientDetails", method = RequestMethod.GET)
	    public Optional getClient(@RequestParam("id") Integer id) {
	        return clienteService.findClient(id);
	    }

	    @RequestMapping(value="/clientes", method= RequestMethod.GET)
	    public List getAllClients() {
	        return clienteService.getAllClients();
	    }

	    @PostMapping(value="/clienteCreate")
	    public void createClient(@RequestBody Cliente client) {	    	
	    	clienteService.createClient(client);
	    }

	    @RequestMapping(value="/clienteDelete", method = RequestMethod.DELETE)
	    public void deleteClient(@RequestParam("id") Integer id) {
	    	clienteService.deleteClientRecord(id);
	    }

	    @RequestMapping(value="/clienteUpdate", method = RequestMethod.PUT)
	    public void updateClient(@RequestBody Cliente client, @RequestParam("id") Integer clientId) {
	    	clienteService.updateClientRecord(client, clientId);
	    }
	    	    
	    @RequestMapping(value="/login", method = RequestMethod.POST)	    
	    public User login(@RequestBody User userLogin) {
	    logger = Logger.getLogger("app.log"); 
		//public User login(@RequestParam("nombreUsuario") String nombreUsuario, @RequestParam("password") String password) {
			utiles util = new utiles();
			try {
				for (User user : util.readFile()) {
					if (user.getNombreUsuario().equals(userLogin.getNombreUsuario()) && user.getPassword().equals(userLogin.getPassword())) {
						String token = getJWTToken(userLogin.getNombreUsuario());
						user.setToken(token);
						logger.getHandlers();					
					    logger.log(Level.INFO, "usuario OK");  
						return user;  
					
					}else {
						logger.getHandlers();					
					    logger.log(Level.SEVERE, "usuario no autorizado");  
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			User userNew = new User();
			return userNew;

		}

		private String getJWTToken(String username) {
			String secretKey = "mySecretKey";
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
			String token = Jwts.builder().setId("softtekJWT").setSubject(username)
					.claim("authorities",
							grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

			return "Bearer " + token;
		}
	    
	 
}