package com.proyecto.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No encontrado!")
public class ProductNotFoundException extends RuntimeException {
    
}
