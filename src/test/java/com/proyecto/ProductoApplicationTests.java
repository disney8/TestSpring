package com.proyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

 
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.io.IOException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.controller.ClienteController;
import com.proyecto.model.Cliente;
import com.proyecto.model.Producto;
import com.proyecto.service.ClienteService;
import org.hamcrest.Matchers;
import org.mockito.ArgumentMatchers;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
public class ProductoApplicationTests{

	   @Autowired
	   WebApplicationContext webApplicationContext;
	   protected MockMvc mvc;
	   
	   protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	   protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   protected <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }
	   
	     
	   @Test
	   public void getProductsList() throws Exception {
			  String uri = "/productos";	
			  mvc   = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			  MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			   int status = mvcResult.getResponse().getStatus();
			   assertEquals(200, status);
			   String content = mvcResult.getResponse().getContentAsString();
			   Producto[] productlist = mapFromJson(content, Producto[].class);
			   assertTrue(productlist.length > 0);			   	   
	   }
	   
	   @Test
	   public void createProduct() throws Exception {
		  String uri = "/productCreate";
	      Producto product = new Producto();
	      product.setNombre("ProductoDisney");
	      product.setPrecio(new Float(10));	      
	      String inputJson = mapToJson(product);
	      mvc   = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "El producto se ha creado satisfactoriamente");
	   }
	   
	   
	   @Test
	   public void productUpdate() throws Exception {
		  String uri = "/productUpdate";
	      Producto product = new Producto();
	      product.setNombre("ProductoDisneyModificado");
	      product.setPrecio(new Float(1555));	      
	      String inputJson = mapToJson(product);
	      mvc   = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson).param("id", "5")).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "El producto se ha modificado satisfactoriamente");
	   }
	   
	  
}
