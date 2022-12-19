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


import com.blog.kariyer.Entities.Users;
import com.blog.kariyer.Services.concretes.UserManager;

@RestController
@RequestMapping("/api/users/")
public class UserController {
	private   UserManager userManager;
	@Autowired
	public UserController(UserManager userManager) {
		super();
		this.userManager = userManager;
	} 
	@PostMapping("add")
	public ResponseEntity<?> create(@Valid @RequestBody Users user){	
		return  ResponseEntity.ok(this.userManager.create(user));
	}

	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@Valid @RequestBody Users user){	
		return  ResponseEntity.ok(this.userManager.update(id,user));
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){	
		return  ResponseEntity.ok(this.userManager.delete(id));
	}
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){	
		return  ResponseEntity.ok(this.userManager.getAll());
	}
	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int id){	
		return  ResponseEntity.ok(this.userManager.getById(id));
	}
	@GetMapping(value="sameName",params= {"first_name","last_name"})//sameName
	public ResponseEntity<?> sameName	
	(@RequestParam("first_name") String first_name,@RequestParam("last_name") String last_name){
		return  ResponseEntity.ok(this.userManager.sameName(first_name,last_name));
	}
	@GetMapping("samePassword")
	public ResponseEntity<?> samePassword(@RequestParam String password){	
		return  ResponseEntity.ok(this.userManager.samePassword(password));
	}
	@GetMapping(value="login",params= {"email","password"})//sameName
	public ResponseEntity<?> login	
	(@RequestParam("email") String email,@RequestParam("password") String password){
		return  ResponseEntity.ok(this.userManager.login(email,password));
	}
	@GetMapping("findByEmail")
	public ResponseEntity<?> findByEmail(@RequestParam String email){	
		return  ResponseEntity.ok(this.userManager.findByEmail(email));
	}
	@GetMapping("findByUserName")
	public ResponseEntity<?> findByUserName(@RequestParam String username){	
		return  ResponseEntity.ok(this.userManager.findByUserName(username));
	}
	@GetMapping("existsByEmail")
	public ResponseEntity<?> existsByEmail(@RequestParam String email){	
		return  ResponseEntity.ok(this.userManager.existsByEmail(email));
	}
	@GetMapping("existsByUserName")
	public ResponseEntity<?> existsByUserName(@RequestParam String username){	
		return  ResponseEntity.ok(this.userManager.existsByUserName(username));
	}

}
