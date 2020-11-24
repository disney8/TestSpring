package com.proyecto.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.entity.Especialidad;
import com.proyecto.entity.Persona;
import com.proyecto.model.Cliente;
import com.proyecto.model.Producto;
import com.proyecto.model.Venta;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PersonaC {	  
	
	   @RequestMapping(value="/persona", method=RequestMethod.GET)
	    public Persona getById(){			   
		    return new Persona(1L, "Disney", "Lopez kenede", "52813413", "Disney@gmail.com");		   
	    }
	   	     
	   @GetMapping("/")
	    public String home() {
	        return "Pagina principal";
	    }
	  	   
	   @GetMapping("/login")	   
	   @ResponseBody
		public String login(@RequestParam(name="name") String name, @RequestParam(name="pass") String pass) { 		   
	        return "autorizado";	       
	        
	    }
	   	   
	   
	  
}
