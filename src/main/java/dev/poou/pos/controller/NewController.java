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
import dev.poou.pos.model.New;
import dev.poou.pos.repository.NewRepository;

@RestController
@RequestMapping("/api")
public class NewController {
	
	@Autowired
	NewRepository newRepository;
	
	
	@GetMapping("/news")
	public List<New> getAllNews() {
		return newRepository.findAll();
	}

	@PostMapping("/news")
	public New createNews(@Valid @RequestBody New noticia) {
		return newRepository.save(noticia);
	}

	@GetMapping("/news/{id}")
	public New getNewById(@PathVariable(value = "id") Long newId) {
		return newRepository.findById(newId).orElseThrow(() -> new ResourceNotFoundException("New", "id", newId));
	}

	@PutMapping("/news/{id}")
	public New updateNew(@PathVariable(value = "id") Long newId, @Valid @RequestBody New newDetail) {

		New noticia = newRepository.findById(newId)
				.orElseThrow(() -> new ResourceNotFoundException("New", "id", newId));

		noticia.setTitle(newDetail.getTitle());
		noticia.setDescription(newDetail.getDescription());
	
		New updateNew = newRepository.save(noticia);
		return updateNew;
	}

	@DeleteMapping("/news/{id}")
	public ResponseEntity<?> deleteNew(@PathVariable(value = "id") Long newId) {
		New noticia = newRepository.findById(newId)
				.orElseThrow(() -> new ResourceNotFoundException("New", "id", newId));

		newRepository.delete(noticia);

		return ResponseEntity.ok().build();
	}
}
