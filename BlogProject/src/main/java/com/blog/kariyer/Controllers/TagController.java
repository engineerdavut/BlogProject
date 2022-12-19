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


import com.blog.kariyer.Entities.Tags;

import com.blog.kariyer.Services.concretes.TagManager;

@RestController
@RequestMapping("/api/tags/")
public class TagController {
	private TagManager tagManager;
	@Autowired
	public TagController(TagManager tagManager) {
		super();
		this.tagManager = tagManager;
	}

	@PostMapping("add")
	public ResponseEntity<?> create(@Valid @RequestBody Tags tag){	
		return  ResponseEntity.ok(this.tagManager.create(tag));
	}

	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@Valid @RequestBody Tags tag){	
		return  ResponseEntity.ok(this.tagManager.update(id,tag));
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){	
		return  ResponseEntity.ok(this.tagManager.delete(id));
	}
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){	
		return  ResponseEntity.ok(this.tagManager.getAll());
	}
	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int id){	
		return  ResponseEntity.ok(this.tagManager.getById(id));
	}
	@GetMapping("getByName")
	public ResponseEntity<?> getByName(@RequestParam String name){	
		return  ResponseEntity.ok(this.tagManager.getByName(name));
	}
	@GetMapping("getByNameContains")
	public ResponseEntity<?> getByNameContains(@RequestParam String name){	
		return  ResponseEntity.ok(this.tagManager.getByNameContains(name));
	}
	@GetMapping("getByNameStartsWith")
	public ResponseEntity<?> getByNameStartsWith(@RequestParam String name){	
		return  ResponseEntity.ok(this.tagManager.getByNameStartsWith(name));
	}
	@GetMapping("existsByName")
	public ResponseEntity<?> existsByName(@RequestParam String name){	
		return  ResponseEntity.ok(this.tagManager.existsByName(name));
	}
}
