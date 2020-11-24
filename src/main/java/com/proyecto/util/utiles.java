package com.proyecto.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.proyecto.model.User;

public class utiles {
	
	private Properties properties = new Properties();
	private String usuario;
	private String password;
	
	// This method is used to load the properties file
		  public void loadPropertiesFile(){
		    InputStream iStream = null;
		      try {
		        // Loading properties file from the path (relative path given here)
		    	  iStream = this.getClass().getClassLoader().getResourceAsStream("app.properties");	         
		    	  properties.load(iStream);
		      } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		      }finally {
		        try {
		          if(iStream != null){
		            iStream.close();
		          }
		        } catch (IOException e) {
		          // TODO Auto-generated catch block
		          e.printStackTrace();
		        }
		      }
		    }
		  
		  /**
		  * Method to read the properties from a * loaded property file
		  */
		  public void readProperties(){
		    System.out.println("User name - " + properties.getProperty("usuario"));
		    System.out.println("Password - " + properties.getProperty("password"));		
		    setPassword(properties.getProperty("password"));
		    setUsuario(properties.getProperty("usuario"));
		  }
		  
		  public List<User> readFile() throws IOException{
			  User user = null;
			  List<User> listuser = new ArrayList<User>(); 
			  ClassLoader classLoader = getClass().getClassLoader();
		      File file = new File(classLoader.getResource("usuarios.txt").getFile());
		      InputStream inputStream = new FileInputStream(file);	  
			
		      InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		      BufferedReader reader = new BufferedReader(streamReader);
		      ArrayList<String> lines = new ArrayList<String>();		      	    	 
		      for (String line; (line = reader.readLine()) != null;) {	
		    	   user = new User();
		    	    lines.add(line);
					Scanner delimitar = new Scanner(line);			
					delimitar.useDelimiter("\\s*,\\s*");					
					user.setNombreUsuario(delimitar.next());
					user.setPassword(delimitar.next());		
					listuser.add(user);
		    	  }		        						
				return listuser;
			  }

		public Properties getProperties() {
			return properties;
		}

		public void setProperties(Properties properties) {
			this.properties = properties;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

}
