package dev.poou.pos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.poou.pos.exception.ResourceNotFoundException;
import dev.poou.pos.model.Product;
import dev.poou.pos.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	
	@GetMapping("/products")
	public List<Product> all() {
		return productRepository.findAll();
	}

	@PostMapping("/products")
	public Product create(@Valid @RequestBody Product objeto) {
		return productRepository.save(objeto);
	}

	@GetMapping("/products/{id}")
	public Product first(@PathVariable(value = "id") Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
	}

	@PutMapping("/products/{id}")
	public Product updated(@PathVariable(value = "id") Long id, @Valid @RequestBody Product objeto) {

		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		
		product.setCode("000001");
		product.setName(objeto.getName());
		product.setQuantity(objeto.getQuantity());
		product.setImage(objeto.getImage());
		
		Product update = productRepository.save(product);
		return update;
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteNew(@PathVariable(value = "id") Long id) {
		
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		productRepository.delete(product);

		return ResponseEntity.ok().build();
	}

}
