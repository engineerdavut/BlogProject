package com.blog.kariyer.Controllers;




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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.kariyer.Entities.Authors;
import com.blog.kariyer.Services.concretes.AuthorManager;

@RestController
@RequestMapping("/api/authors/")
public class AuthorController {
	private AuthorManager authorManager;
	@Autowired
	public AuthorController(AuthorManager authorManager) {
		super();
		this.authorManager = authorManager;
	}
	@PostMapping("beawriter")
	public ResponseEntity<?> create(@Valid @RequestBody Authors author){
		return ResponseEntity.ok(this.authorManager.create(author));
		
	}
	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@Valid @RequestBody Authors author){
		return ResponseEntity.ok(this.authorManager.update(id,author));
		
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return ResponseEntity.ok(this.authorManager.delete(id));
		
	}
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.authorManager.getAll());
		
	}
	@GetMapping("getById") 
	public ResponseEntity<?> getById(@RequestParam int id){
		return ResponseEntity.ok(this.authorManager.getById(id));
		
	}
	@GetMapping("findByAvatar")
	public ResponseEntity<?> findByAvatar(@RequestParam String avatar){
		return ResponseEntity.ok(this.authorManager.findByAvatar(avatar));
		
	}
	@GetMapping("getByDescriptionContains")
	public ResponseEntity<?> getByDescriptionContains(@RequestParam String description){
		return ResponseEntity.ok(this.authorManager.getByDescriptionContains(description));
		
	}
	@GetMapping("getByDescriptionStartsWith")
	public ResponseEntity<?> getByDescriptionStartsWith(@RequestParam String description){
		return ResponseEntity.ok(this.authorManager.getByDescriptionStartsWith(description));
		
	}
	@GetMapping("existsByAvatar")
	public ResponseEntity<?> existsByAvatar(@RequestParam String avatar){
		return ResponseEntity.ok(this.authorManager.existsByAvatar(avatar));
		
	}


}
