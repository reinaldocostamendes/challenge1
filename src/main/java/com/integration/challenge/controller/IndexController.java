package com.integration.challenge.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.integration.challenge.model.Product;
import com.integration.challenge.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class IndexController {
	@Autowired
	private ProductService productService;

	@GetMapping( value = {"/"}, produces = "application/json")
	public  ResponseEntity<List<Product>> index() {
		List<Product> products= productService.getAll();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping( value = {"/products"}, produces = "application/json")
	public  ResponseEntity<List<Product>> products() {
		List<Product> products= productService.getAll();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	@PostMapping(value = {"/saveProduct", "*/saveProduct"},produces = "application/json")
	public  ResponseEntity<Product> saveProduct(@RequestBody Product product)
			throws IOException {
		Product product_saved = productService.addOrUpdateProduct(product);
		return new  ResponseEntity<Product>(product_saved,HttpStatus.OK);
	}

	@PutMapping(value = {"/updateProduct", "*/updateProduct"},produces = "application/json")
	public  ResponseEntity<Product> udpateProduct(@RequestBody Product product)
			throws IOException {
		Product product_saved = productService.addOrUpdateProduct(product);
		return new  ResponseEntity<Product>(product_saved,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteProduct/{id}", produces = "application/text")
	public String deleteTelefone(@PathVariable("id") int id) throws Exception {
		productService.deleteProduct(id);
		return "Delected successfull";
	}

}
