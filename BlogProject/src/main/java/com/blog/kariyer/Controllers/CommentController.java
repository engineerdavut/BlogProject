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

import com.blog.kariyer.Entities.Comments;
import com.blog.kariyer.Services.concretes.CommentManager;

@RestController
@RequestMapping("/api/comments/")
public class CommentController {
	private CommentManager commentManager;
	@Autowired
	public CommentController(CommentManager commentManager) {
		super();
		this.commentManager = commentManager;
	}
	@PostMapping("add")
	public ResponseEntity<?> create(@Valid @RequestBody Comments comment){	
		return  ResponseEntity.ok(this.commentManager.create(comment));
	}
	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@Valid @RequestBody Comments comment){	
		return  ResponseEntity.ok(this.commentManager.update(id,comment));
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){	
		return  ResponseEntity.ok(this.commentManager.delete(id));
	}
	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int id){	
		return  ResponseEntity.ok(this.commentManager.getById(id));
	}

	@GetMapping("findByPostId")
	public ResponseEntity<?> findByPostId(@RequestParam int id){	
		return  ResponseEntity.ok(this.commentManager.findByPostId(id));
	}
	@GetMapping("findByUserId")
	public ResponseEntity<?> findByUserId(@RequestParam int id){	
		return  ResponseEntity.ok(this.commentManager.findByUserId(id));
	}
	@GetMapping("findByStatus")
	public ResponseEntity<?> findByStatus(@RequestParam boolean status){	
		return  ResponseEntity.ok(this.commentManager.findByStatus(status));
	}
	@GetMapping("getByContentContains")
	public ResponseEntity<?> getByContentContains(@RequestParam String content){	
		return  ResponseEntity.ok(this.commentManager.getByContentContains(content));
	}
	@GetMapping("getByContentStartsWith")//findByUserIdAndPostId
	public ResponseEntity<?> getByContentStartsWith(@RequestParam String content){	
		return  ResponseEntity.ok(this.commentManager.getByContentStartsWith(content));
	}
	@GetMapping(value="findByUserIdAndPostId",params={"userid","postid"})
	public ResponseEntity<?> findByUserIdAndPostId(@RequestParam("userid") int userid,@RequestParam("postid") int postid){	
		return  ResponseEntity.ok(this.commentManager.findByUserIdAndPostId(userid,postid));
	}
	@GetMapping(value="getAllBetweenDates",params= {"startDate","endDate"})
	public ResponseEntity<?> getAllBetweenDates(@RequestParam("startDate") @DateTimeFormat(pattern = "dd.MM.yyyy")  Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "dd.MM.yyyy")  Date endDate){	
		return  ResponseEntity.ok(this.commentManager.getAllBetweenDates(startDate,endDate));
	}
	@GetMapping(value="getByUserIdAllBetweenDates",params= {"userid","startDate","endDate"})
	public ResponseEntity<?> getByUserIdAllBetweenDates(@RequestParam("userid")int userid,@RequestParam("startDate") 
	@DateTimeFormat(pattern = "dd.MM.yyyy")  Date startDate,@RequestParam("endDate") @DateTimeFormat(pattern = "dd.MM.yyyy")  Date endDate){	
		return  ResponseEntity.ok(this.commentManager.getByUserIdAllBetweenDates(userid,startDate,endDate));
	}
	@GetMapping(value="getByPostIdAllBetweenDates",params= {"postid","startDate","endDate"})
	public ResponseEntity<?> getByPostIdAllBetweenDates(@RequestParam("postid")int postid,@RequestParam("startDate") 
	@DateTimeFormat(pattern = "dd.MM.yyyy")  Date startDate,@RequestParam("endDate") @DateTimeFormat(pattern = "dd.MM.yyyy")  Date endDate){	
		return  ResponseEntity.ok(this.commentManager.getByPostIdAllBetweenDates(postid,startDate,endDate));
	}

}
