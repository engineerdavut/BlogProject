package com.blog.kariyer.Controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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


import com.blog.kariyer.Entities.Posts;

import com.blog.kariyer.Services.concretes.PostManager;

@RestController
@RequestMapping("/api/posts/")
public class PostController {
	private PostManager postManager;
	@Autowired
	public PostController(PostManager postManager) {
		super();
		this.postManager = postManager;
	}
	

	@PostMapping("add")
	public ResponseEntity<?> create(@Valid @RequestBody Posts post){	
		return  ResponseEntity.ok(this.postManager.create(post));
	}
	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@Valid @RequestBody Posts post){	
		return  ResponseEntity.ok(this.postManager.update(id,post));
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){	
		return  ResponseEntity.ok(this.postManager.delete(id));
	}
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){	
		return  ResponseEntity.ok(this.postManager.getAll());
	}
	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int id){	
		return  ResponseEntity.ok(this.postManager.getById(id));
	}
	@GetMapping(value="getPaginated",params= {"pageNo","pageSize"})
	public ResponseEntity<?> getPaginated(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize){	
		return  ResponseEntity.ok(this.postManager.getPaginated(pageNo,pageSize));
	}
	@GetMapping(value="getPaginatedAndSorted",params= {"pageNo","pageSize","sortField","sortDirection"})
	public ResponseEntity<?> getPaginatedAndSorted(@RequestParam("pageNo") int pageNo,	
			@RequestParam("pageSize") int pageSize,
			@RequestParam("sortField") String sortField,@RequestParam("sortDirection") String sortDirection){
		return  ResponseEntity.ok
				(this.postManager.getPaginatedAndSorted(pageNo,pageSize,sortField,sortDirection));
	}
	@GetMapping("findByAuthorId")
	public ResponseEntity<?> findByAuthorId(@RequestParam int id){	
		return  ResponseEntity.ok(this.postManager.findByAuthorId(id));
	}
	@GetMapping("findByTagId")
	public ResponseEntity<?> findByTagId(@RequestParam int id){	
		return  ResponseEntity.ok(this.postManager.findByTagId(id));
	}
	@GetMapping("findByStatus")//getByContentContains
	public ResponseEntity<?> findByStatus(@RequestParam boolean status){	
		return  ResponseEntity.ok(this.postManager.findByStatus(status));
	}
	@GetMapping("getByContentContains")
	public ResponseEntity<?> getByContentContains(@RequestParam String content){	
		return  ResponseEntity.ok(this.postManager.getByContentContains(content));
	}
	@GetMapping("getByContentStartsWith")
	public ResponseEntity<?> getByContentStartsWith(@RequestParam String content){	
		return  ResponseEntity.ok(this.postManager.getByContentStartsWith(content));
	}
	@GetMapping("getByTitleContains")
	public ResponseEntity<?> getByTitleContains(@RequestParam String title){	
		return  ResponseEntity.ok(this.postManager.getByTitleContains(title));
	}
	@GetMapping("getByTitleStartsWith")
	public ResponseEntity<?> getByTitleStartsWith(@RequestParam String title){	
		return  ResponseEntity.ok(this.postManager.getByTitleStartsWith(title));
	}
	@GetMapping("getByTitle")
	public ResponseEntity<?> getByTitle(@RequestParam String title){	
		return  ResponseEntity.ok(this.postManager.getByTitle(title));
	}
	@GetMapping(value="getAllBetweenDates",params= {"startDate","endDate"})
	public ResponseEntity<?> getAllBetweenDates(@RequestParam("startDate") 
		@DateTimeFormat(pattern = "dd.MM.yyyy") Date startDate,@RequestParam("endDate") 
		@DateTimeFormat(pattern = "dd.MM.yyyy")Date endDate){	
		return  ResponseEntity.ok(this.postManager.getAllBetweenDates(startDate,endDate));
	
	}
}
