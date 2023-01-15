package com.example.tarea12;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
	
	static List<Saludo> saludo=new ArrayList<Saludo>();
    static {
        saludo.add(new Saludo("Hola"));
    }
    
    @GetMapping("/hello")
	public List<Saludo> getSaludo() {
    	return saludo;
	}
    
    @PostMapping(path="/hello",consumes="application/json")
    public ResponseEntity<String> insertarSaludo(@RequestBody Saludo s){
    	saludo.add(s);
    	return new ResponseEntity(HttpStatus.OK);
    }
	
}
