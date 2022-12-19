package com.blog.kariyer.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.blog.kariyer.Entities.Likes;
import com.blog.kariyer.Services.concretes.LikeManager;

@RestController
@RequestMapping("/api/likes/")
public class LikeController {
	private LikeManager likeManager;
	@Autowired
	public LikeController(LikeManager likeManager) {
		super();
		this.likeManager = likeManager;
	}
	@PostMapping("add")
	public ResponseEntity<?> create(@Valid @RequestBody Likes like){	
		return  ResponseEntity.ok(this.likeManager.create(like));
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){	
		return  ResponseEntity.ok(this.likeManager.delete(id));
	}
	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int id){	
		return  ResponseEntity.ok(this.likeManager.getById(id));
	}
	@GetMapping("findByUserId")
	public ResponseEntity<?> findByUserId(@RequestParam int id){	
		return  ResponseEntity.ok(this.likeManager.findByUserId(id));
	}
	@GetMapping("findByPostId")
	public ResponseEntity<?> findByPostId(@RequestParam int id){	
		return  ResponseEntity.ok(this.likeManager.findByPostId(id));
	}
	

}
